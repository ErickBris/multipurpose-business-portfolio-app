<?php

$this->pageTitle=$model->label() . ': ' . GxHtml::valueEx($model);

$this->breadcrumbs = array(
	$model->label(2) => array('index'),
	GxHtml::valueEx($model),
);

$this->menu=array(
	array('label'=>Yii::t('app', 'List') . ' ' . $model->label(2), 'url'=>array('index')),
	array('label'=>Yii::t('app', 'Create') . ' ' . $model->label(), 'url'=>array('create')),
	array('label'=>Yii::t('app', 'Update') . ' ' . $model->label(), 'url'=>array('update', 'id' => $model->id)),
	array('label'=>Yii::t('app', 'Update image for this') . ' ' . $model->label(),$model->label(5), 'url'=>array('image', 'id' => $model->id)),
	array('label'=>Yii::t('app', 'Delete') . ' ' . $model->label(), 'url'=>'#', 'linkOptions' => array('submit' => array('delete', 'id' => $model->id), 'confirm'=>'Are you sure you want to delete this item?')),
	array('label'=>Yii::t('app', 'Manage') . ' ' . $model->label(2), 'url'=>array('admin')),
);
?>

<?php if(Yii::app()->user->hasFlash('success')):?>
    <div class="flash-success" id="flash-message">
        <?php echo Yii::app()->user->getFlash('success'); ?>
    </div>
<?php endif; ?>

<?php
Yii::app()->clientScript->registerScript(
   'flash-message',
   '$(".flash-success").animate({opacity: 1.0}, 3000).fadeOut("slow");',
   CClientScript::POS_READY
);
?>

<h1><?php echo GxHtml::encode($model->label()) . ': ' . GxHtml::encode(GxHtml::valueEx($model)); ?></h1>

<?php $this->widget('zii.widgets.CDetailView', array(
	'data' => $model,
	'attributes' => array(
'id',
array(
	'name'=>'image',
	'type'=>'html',
	'value'=>$model->image !== null ? CHtml::image('/business/uploads/' . $model->id . $model->image) : null,
),
'name',
	),
)); ?>

<h2><?php echo GxHtml::encode($model->getRelationLabel('galleryImages')); ?></h2>
<?php
	echo GxHtml::openTag('ul');
	foreach($model->galleryImages as $relatedModel) {
		echo GxHtml::openTag('li');
		echo GxHtml::link(GxHtml::encode(GxHtml::valueEx($relatedModel)), array('galleryImage/view', 'id' => GxActiveRecord::extractPkValue($relatedModel, true)));
		echo GxHtml::closeTag('li');
	}
	echo GxHtml::closeTag('ul');
?>