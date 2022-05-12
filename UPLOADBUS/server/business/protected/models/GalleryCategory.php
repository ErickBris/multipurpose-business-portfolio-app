<?php

Yii::import('application.models._base.BaseGalleryCategory');

class GalleryCategory extends BaseGalleryCategory
{
	public static function model($className=__CLASS__) {
		return parent::model($className);
	}

	public static function label($n = 1) {
		return Yii::t('app', 'Category|Categories', $n);
	}

	public static function representingColumn() {
		return 'name';
	}
}