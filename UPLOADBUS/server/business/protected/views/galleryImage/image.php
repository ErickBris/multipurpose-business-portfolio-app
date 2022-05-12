<?php
$this->breadcrumbs = array(
	$model->label(2) => array('index'),
	GxHtml::valueEx($model) => array('view', 'id' => GxActiveRecord::extractPkValue($model, true)),
	Yii::t('app','Image'),
);

$this->menu=array(
	array('label'=>Yii::t('app', 'View') . ' ' . $model->label(4), 'url'=>array('index')),
	array('label'=>Yii::t('app', 'Create') . ' ' . $model->label(5), 'url'=>array('create')),
	array('label'=>Yii::t('app', 'View') . ' ' . $model->label(5), 'url'=>array('view', 'id' => $model->id)),
	array('label'=>Yii::t('app', 'Update') . ' ' . $model->label(5), 'url'=>array('update', 'id' => $model->id)),
	array('label'=>Yii::t('app', 'Manage') . ' ' . $model->label(4), 'url'=>array('admin')),
);
?>
<h1>Image for <?php echo $model->label(5) . ': ' . GxHtml::encode(GxHtml::valueEx($model)); ?></h1>

<?php $this->renderPartial('_image', array(
			'model' => $model,
		)); ?>