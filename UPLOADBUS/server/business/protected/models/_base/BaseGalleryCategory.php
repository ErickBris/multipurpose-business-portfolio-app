<?php

/**
 * This is the model base class for the table "gallery_category".
 * DO NOT MODIFY THIS FILE! It is automatically generated by giix.
 * If any changes are necessary, you must set or override the required
 * property or method in class "GalleryCategory".
 *
 * Columns in table "gallery_category" available as properties of the model,
 * followed by relations of table "gallery_category" available as properties of the model.
 *
 * @property integer $id
 * @property string $image
 * @property string $name
 *
 * @property GalleryImage[] $galleryImages
 */
abstract class BaseGalleryCategory extends GxActiveRecord {

	public static function model($className=__CLASS__) {
		return parent::model($className);
	}

	public function tableName() {
		return 'gallery_category';
	}

	public static function label($n = 1) {
		return Yii::t('app', 'GalleryCategory|GalleryCategories', $n);
	}

	public static function representingColumn() {
		return 'image';
	}

	public function rules() {
		return array(
			array('image, name', 'required'),
			array('image', 'length', 'max'=>1024),
			array('name', 'length', 'max'=>255),
			array('id, image, name', 'safe', 'on'=>'search'),
		);
	}

	public function relations() {
		return array(
			'galleryImages' => array(self::HAS_MANY, 'GalleryImage', 'id_category'),
		);
	}

	public function pivotModels() {
		return array(
		);
	}

	public function attributeLabels() {
		return array(
			'id' => Yii::t('app', 'ID'),
			'image' => Yii::t('app', 'Image'),
			'name' => Yii::t('app', 'Name'),
			'galleryImages' => null,
		);
	}

	public function search() {
		$criteria = new CDbCriteria;

		$criteria->compare('id', $this->id);
		$criteria->compare('image', $this->image, true);
		$criteria->compare('name', $this->name, true);

		return new CActiveDataProvider($this, array(
			'criteria' => $criteria,
		));
	}
}