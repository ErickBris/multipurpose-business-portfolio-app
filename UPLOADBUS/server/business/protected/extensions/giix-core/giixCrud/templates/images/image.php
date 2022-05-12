<?php echo '<?php'; ?>

$this->breadcrumbs = array(
	$model->label(2) => array('index'),
	GxHtml::valueEx($model) => array('view', 'id' => GxActiveRecord::extractPkValue($model, true)),
	Yii::t('app','Slika'),
);

$this->menu=array(
	array('label'=>Yii::t('app', 'Pregledaj') . ' ' . $model->label(4), 'url'=>array('index')),
	array('label'=>Yii::t('app', 'Dodaj') . ' ' . $model->label(5), 'url'=>array('create')),
	array('label'=>Yii::t('app', 'Pregledaj ovu') . ' ' . $model->label(5), 'url'=>array('view', 'id' => $model->id)),
	array('label'=>Yii::t('app', 'Uredi ovu') . ' ' . $model->label(5), 'url'=>array('update', 'id' => $model->id)),
	array('label'=>Yii::t('app', 'Uredi sve') . ' ' . $model->label(4), 'url'=>array('admin')),
);
<?php echo '?>'; ?>

<h1>Slika za <?php echo '<?php'; ?> echo $model->label(5) . ': ' . GxHtml::encode(GxHtml::valueEx($model)); <?php echo '?>'; ?></h1>

<?php echo '<?php'; ?> $this->renderPartial('_image', array(
			'model' => $model,
		)); <?php echo '?>'; ?>