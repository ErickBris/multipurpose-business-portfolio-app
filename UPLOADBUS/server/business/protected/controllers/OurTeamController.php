<?php

class OurTeamController extends GxController {
	
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
		$model = $this->loadModel($id, 'OurTeam');
		if (isset($_POST['OurTeam'])) {
			$model->attributes = $_POST['OurTeam'];
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
		$query = "SELECT *
				FROM our_team WHERE is_active = 1";
        $connection=Yii::app()->db;
        $command=$connection->createCommand($query);
        $dataReader=$command->query();
		foreach($dataReader as $row) {
			$result[]=$row;
		}
		$rows=$dataReader->readAll();
		echo '{"our_team":' . json_encode($result) . '}';
	}
	

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'OurTeam'),
		));
	}

	public function actionCreate() {
		$model = new OurTeam;


		if (isset($_POST['OurTeam'])) {
			$model->setAttributes($_POST['OurTeam']);

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
					Yii::app()->user->setFlash('success', Yii::t('app', 'You have successfully added a new ' . $model->label(5)));
					$this->redirect(array('view', 'id' => $model->id));
				}
			}
		}

		$this->render('create', array( 'model' => $model));
	}

	public function actionUpdate($id) {
		$model = $this->loadModel($id, 'OurTeam');


		if (isset($_POST['OurTeam'])) {
			$model->setAttributes($_POST['OurTeam']);

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
			$this->loadModel($id, 'OurTeam')->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('admin'));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionIndex() {
		$dataProvider = new CActiveDataProvider('OurTeam');
		$this->render('index', array(
			'dataProvider' => $dataProvider,
		));
	}

	public function actionAdmin() {
		$model = new OurTeam('search');
		$model->unsetAttributes();

		if (isset($_GET['OurTeam']))
			$model->setAttributes($_GET['OurTeam']);

		$this->render('admin', array(
			'model' => $model,
		));
	}

}