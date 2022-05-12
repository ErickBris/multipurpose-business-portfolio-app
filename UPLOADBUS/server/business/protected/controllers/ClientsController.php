<?php

class ClientsController extends GxController {
	
	public function filters() {
		return array(
				'accessControl',
		);
	}
	
	public function accessRules() {
		return array(
				array('allow',
						'actions'=>array('api'),
						'users'=>array('*'),
				),
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
		$model = $this->loadModel($id, 'Clients');
		if (isset($_POST['Clients'])) {
			$model->attributes = $_POST['Clients'];
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
	
	public function actionApi() {
		$result = Array();
		$query = "SELECT id, name, image, description, website
				FROM clients WHERE is_active = 1";
        $connection=Yii::app()->db;
        $command=$connection->createCommand($query);
        $dataReader=$command->query();
		foreach($dataReader as $row) {
			$result[]=$row;
		}
		$rows=$dataReader->readAll();
		echo '{"client":' . json_encode($result) . '}';
	}

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'Clients'),
		));
	}

	public function actionCreate() {
		$model = new Clients;


		if (isset($_POST['Clients'])) {
			$model->setAttributes($_POST['Clients']);

			$model -> image = EUploadedImage::getInstance($model, 'image');
			$model -> image -> maxWidth = 640;
			$model -> image -> maxHeight = 640;
			$model -> image -> thumb = array('maxWidth' => 200, 'maxHeight' => 200, 'dir' => 'thumbs', 'prefix' => 'thumbs_', );

			if ($model->save()) {
				if (Yii::app()->getRequest()->getIsAjaxRequest()) {
					if ($model -> image != '')
						$model -> image -> saveAs('uploads/' . $model -> id . $model -> image);
					Yii::app()->end();
				}
				else {
					if ($model -> image != '')
						$model -> image -> saveAs('uploads/' . $model -> id . $model -> image);
					Yii::app()->user->setFlash('success', Yii::t('app', 'You have successfully added a new  ' . $model->label(5)));
					$this->redirect(array('view', 'id' => $model->id));
				}
			}
		}

		$this->render('create', array( 'model' => $model));
	}

	public function actionUpdate($id) {
		$model = $this->loadModel($id, 'Clients');


		if (isset($_POST['Clients'])) {
			$model->setAttributes($_POST['Clients']);

			if ($model->save()) {
				Yii::app()->user->setFlash('success', Yii::t('app', 'You have successfully changed the data.'));
				$this->redirect(array('view', 'id' => $model->id));
			}
		}

		$this->render('update', array(
				'model' => $model,
				));
	}

	public function actionDelete($id) {
		if (Yii::app()->getRequest()->getIsPostRequest()) {
			$this->loadModel($id, 'Clients')->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('admin'));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionIndex() {
		$dataProvider = new CActiveDataProvider('Clients');
		$this->render('index', array(
			'dataProvider' => $dataProvider,
		));
	}

	public function actionAdmin() {
		$model = new Clients('search');
		$model->unsetAttributes();

		if (isset($_GET['Clients']))
			$model->setAttributes($_GET['Clients']);

		$this->render('admin', array(
			'model' => $model,
		));
	}

}