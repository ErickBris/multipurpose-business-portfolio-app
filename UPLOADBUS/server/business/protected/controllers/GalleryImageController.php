<?php

class GalleryImageController extends GxController {

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
		$model = $this->loadModel($id, 'GalleryImage');
		if (isset($_POST['GalleryImage'])) {
			$model->attributes = $_POST['GalleryImage'];
			$model->image=EUploadedImage::getInstance($model,'image');
			//$model->image->maxWidth = 640;
			//$model->image->maxHeight = 640;
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



	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'GalleryImage'),
		));
	}

	public function actionCreate() {
		$model = new GalleryImage;


		if (isset($_POST['GalleryImage'])) {
			$model->setAttributes($_POST['GalleryImage']);

			$model -> image = EUploadedImage::getInstance($model, 'image');
			//$model -> image -> maxWidth = 640;
			//$model -> image -> maxHeight = 640;
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
					Yii::app()->user->setFlash('success', Yii::t('app', 'Uspješno ste dodali novu ' . $model->label(5)));
					$this->redirect(array('view', 'id' => $model->id));
				}
			}
		}

		$this->render('create', array( 'model' => $model));
	}

	public function actionUpdate($id) {
		$model = $this->loadModel($id, 'GalleryImage');


		if (isset($_POST['GalleryImage'])) {
			$model->setAttributes($_POST['GalleryImage']);

			if ($model->save()) {
				Yii::app()->user->setFlash('success', Yii::t('app', 'Uspješno ste izmijenili podatke.'));
				$this->redirect(array('view', 'id' => $model->id));
			}
		}

		$this->render('update', array(
				'model' => $model,
				));
	}

	public function actionDelete($id) {
		if (Yii::app()->getRequest()->getIsPostRequest()) {
			$this->loadModel($id, 'GalleryImage')->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('admin'));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionIndex() {
		$dataProvider = new CActiveDataProvider('GalleryImage');
		$this->render('index', array(
			'dataProvider' => $dataProvider,
		));
	}

	public function actionAdmin() {
		$model = new GalleryImage('search');
		$model->unsetAttributes();

		if (isset($_GET['GalleryImage']))
			$model->setAttributes($_GET['GalleryImage']);

		$this->render('admin', array(
			'model' => $model,
		));
	}

}