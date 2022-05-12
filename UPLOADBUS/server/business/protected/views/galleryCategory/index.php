<?php

$this->breadcrumbs = array(
	GalleryCategory::label(2),
	Yii::t('app', 'Index'),
);

$this->menu = array(
	array('label'=>Yii::t('app', 'Create') . ' ' . GalleryCategory::label(), 'url' => array('create')),
	array('label'=>Yii::t('app', 'Manage') . ' ' . GalleryCategory::label(2), 'url' => array('admin')),
);
?>

<h1><?php echo GxHtml::encode(GalleryCategory::label(2)); ?></h1>

<?php $this->widget('zii.widgets.CListView', array(
	'dataProvider'=>$dataProvider,
	'itemView'=>'_view',
)); 