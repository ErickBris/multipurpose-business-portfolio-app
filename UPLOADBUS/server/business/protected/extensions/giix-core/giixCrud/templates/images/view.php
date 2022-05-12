<?php
/**
 * The following variables are available in this template:
 * - $this: the CrudCode object
 */
?>
<?php
echo "<?php\n\n\$this->pageTitle=\$model->label() . ': ' . GxHtml::valueEx(\$model);\n
\$this->breadcrumbs = array(
	\$model->label(2) => array('index'),
	GxHtml::valueEx(\$model),
);\n";
?>

$this->menu=array(
	array('label'=>Yii::t('app', 'Pregledaj') . ' ' . $model->label(4), 'url'=>array('index')),
	array('label'=>Yii::t('app', 'Dodaj') . ' ' . $model->label(5), 'url'=>array('create')),
	array('label'=>Yii::t('app', 'Uredi ovu') . ' ' . $model->label(5), 'url'=>array('update', 'id' => $model-><?php echo $this->tableSchema->primaryKey; ?>)),
	array('label'=>Yii::t('app', 'Uredi sliku za ovu') . ' ' . $model->label(5), 'url'=>array('image', 'id' => $model->id)),
	array('label'=>Yii::t('app', 'Obriši ovu') . ' ' . $model->label(5), 'url'=>'#', 'linkOptions' => array('submit' => array('delete', 'id' => $model-><?php echo $this->tableSchema->primaryKey; ?>), 'confirm'=>'Da li želite obrisati ovu stavku?')),
	array('label'=>Yii::t('app', 'Uredi sve') . ' ' . $model->label(4), 'url'=>array('admin')),
);
?>

<?php echo "<?php if(Yii::app()->user->hasFlash('success')):?>\n"; ?>
    <div class="flash-success" id="flash-message">
        <?php echo "<?php echo Yii::app()->user->getFlash('success'); ?>\n"; ?>
    </div>
<?php echo "<?php endif; ?>\n"; ?>

<?php echo "<?php\n"; ?>
Yii::app()->clientScript->registerScript(
   'flash-message',
   '$(".flash-success").animate({opacity: 1.0}, 3000).fadeOut("slow");',
   CClientScript::POS_READY
);
<?php echo "?>\n"; ?>

<h1><?php echo '<?php'; ?> echo GxHtml::encode($model->label()) . ': ' . GxHtml::encode(GxHtml::valueEx($model)); ?></h1>

<?php echo '<?php'; ?> $this->widget('zii.widgets.CDetailView', array(
	'data' => $model,
	'nullDisplay' => Yii::t('app','<span class="null">Nije postavljeno</span>'),
	'attributes' => array(
<?php
foreach ($this->tableSchema->columns as $column)
		echo $this->generateDetailViewAttribute($this->modelClass, $column) . ",\n";
?>
	),
)); ?>

<?php foreach (GxActiveRecord::model($this->modelClass)->relations() as $relationName => $relation): ?>
<?php if ($relation[0] == GxActiveRecord::HAS_MANY || $relation[0] == GxActiveRecord::MANY_MANY): ?>
<h2><?php echo '<?php'; ?> echo GxHtml::encode($model->getRelationLabel('<?php echo $relationName; ?>')); ?></h2>
<?php echo "<?php\n"; ?>
	echo GxHtml::openTag('ul');
	foreach($model-><?php echo $relationName; ?> as $relatedModel) {
		echo GxHtml::openTag('li');
		echo GxHtml::link(GxHtml::encode(GxHtml::valueEx($relatedModel)), array('<?php echo strtolower($relation[1][0]) . substr($relation[1], 1); ?>/view', 'id' => GxActiveRecord::extractPkValue($relatedModel, true)));
		echo GxHtml::closeTag('li');
	}
	echo GxHtml::closeTag('ul');
<?php echo '?>'; ?>
<?php endif; ?>
<?php endforeach; ?>