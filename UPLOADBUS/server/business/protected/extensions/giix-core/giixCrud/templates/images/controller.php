<?php
/**
 * This is the template for generating a controller class file for CRUD feature.
 * The following variables are available in this template:
 * - $this: the CrudCode object
 */
?>
<?php echo "<?php\n"; ?>

class <?php echo $this->controllerClass; ?> extends <?php echo $this->baseControllerClass; ?> {

	public function filters() {
		return array(
				'accessControl',
		);
	}
	
	public function accessRules() {
		return array(
				array('allow',
						'actions'=>array('admin','delete','create','update','index','view','image'),
						'users'=>array('@'),
				),
				array('deny',
						'users'=>array('*'),
				),
		);
	}

	public function actionImage($id) {
		$model = $this->loadModel($id, '<?php echo $this->modelClass; ?>');
		if (isset($_POST['<?php echo $this->modelClass; ?>'])) {
			$model->attributes = $_POST['<?php echo $this->modelClass; ?>'];
			$model->image=EUploadedImage::getInstance($model,'image');
			$model->image->maxWidth = 640;
			$model->image->maxHeight = 640;
			$model->image->thumb = array(
   				'maxWidth' => 200,
    			'maxHeight' => 200,
    			'dir' => 'thumbs',
    			'prefix' => 'thumbs_',
				);
			if ($model->save()) {
				if ($model -> image != '')
						$model->image->saveAs('uploads/'.$model->id.$model->image);
				$this->redirect(array('view', 'id' => $model->id));
			}
		}
		
		$this->render('image', array(
			'model' => $model,
		));
	}


<?php 
	$authpath = 'ext.giix-core.giixCrud.templates.default.auth.';
	Yii::app()->controller->renderPartial($authpath . $this->authtype);
?>

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, '<?php echo $this->modelClass; ?>'),
		));
	}

	public function actionCreate() {
		$model = new <?php echo $this->modelClass; ?>;

<?php if ($this->enable_ajax_validation): ?>
		$this->performAjaxValidation($model, '<?php echo $this->class2id($this->modelClass)?>-form');
<?php endif; ?>

		if (isset($_POST['<?php echo $this->modelClass; ?>'])) {
			$model->setAttributes($_POST['<?php echo $this->modelClass; ?>']);

			$model -> image = EUploadedImage::getInstance($model, 'image');
			$model -> image -> maxWidth = 640;
			$model -> image -> maxHeight = 640;
			$model -> image -> thumb = array('maxWidth' => 200, 'maxHeight' => 200, 'dir' => 'thumbs', 'prefix' => 'thumbs_', );
<?php if ($this->hasManyManyRelation($this->modelClass)): ?>
			$relatedData = <?php echo $this->generateGetPostRelatedData($this->modelClass, 4); ?>;
<?php endif; ?>

<?php if ($this->hasManyManyRelation($this->modelClass)): ?>
			if ($model->saveWithRelated($relatedData)) {
<?php else: ?>
			if ($model->save()) {
<?php endif; ?>
				if (Yii::app()->getRequest()->getIsAjaxRequest()) {
					if ($model -> image != '')
						$model -> image -> saveAs('uploads/' . $model -> id . $model -> image);
					Yii::app()->end();
				}
				else {
					if ($model -> image != '')
						$model -> image -> saveAs('uploads/' . $model -> id . $model -> image);
					Yii::app()->user->setFlash('success', Yii::t('app', 'Uspješno ste dodali novu ' . $model->label(5)));
					$this->redirect(array('view', 'id' => $model->id));
				}
			}
		}

		$this->render('create', array( 'model' => $model));
	}

	public function actionUpdate($id) {
		$model = $this->loadModel($id, '<?php echo $this->modelClass; ?>');

<?php if ($this->enable_ajax_validation): ?>
		$this->performAjaxValidation($model, '<?php echo $this->class2id($this->modelClass)?>-form');
<?php endif; ?>

		if (isset($_POST['<?php echo $this->modelClass; ?>'])) {
			$model->setAttributes($_POST['<?php echo $this->modelClass; ?>']);
<?php if ($this->hasManyManyRelation($this->modelClass)): ?>
			$relatedData = <?php echo $this->generateGetPostRelatedData($this->modelClass, 4); ?>;
<?php endif; ?>

<?php if ($this->hasManyManyRelation($this->modelClass)): ?>
			if ($model->saveWithRelated($relatedData)) {
<?php else: ?>
			if ($model->save()) {
<?php endif; ?>
				Yii::app()->user->setFlash('success', Yii::t('app', 'Uspješno ste izmijenili podatke.'));
				$this->redirect(array('view', 'id' => $model-><?php echo $this->tableSchema->primaryKey; ?>));
			}
		}

		$this->render('update', array(
				'model' => $model,
				));
	}

	public function actionDelete($id) {
		if (Yii::app()->getRequest()->getIsPostRequest()) {
			$this->loadModel($id, '<?php echo $this->modelClass; ?>')->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('admin'));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionIndex() {
		$dataProvider = new CActiveDataProvider('<?php echo $this->modelClass; ?>');
		$this->render('index', array(
			'dataProvider' => $dataProvider,
		));
	}

	public function actionAdmin() {
		$model = new <?php echo $this->modelClass; ?>('search');
		$model->unsetAttributes();

		if (isset($_GET['<?php echo $this->modelClass; ?>']))
			$model->setAttributes($_GET['<?php echo $this->modelClass; ?>']);

		$this->render('admin', array(
			'model' => $model,
		));
	}

}