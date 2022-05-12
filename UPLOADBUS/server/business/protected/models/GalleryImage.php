<?php

Yii::import('application.models._base.BaseGalleryImage');

class GalleryImage extends BaseGalleryImage
{
	public static function model($className=__CLASS__) {
		return parent::model($className);
	}

	public static function label($n = 1) {
		return Yii::t('app', 'Image|Images', $n);
	}
}