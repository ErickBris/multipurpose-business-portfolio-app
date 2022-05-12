<?php
/**
 * The following variables are available in this template:
 * - $this: the CrudCode object
 */
?>
<?php
echo "<?php\n\n\$this->pageTitle=Yii::t('app', 'Uredi') . ' ' . \$model->label(4);\n
\$this->breadcrumbs = array(
	\$model->label(2) => array('index'),
	Yii::t('app', 'Uredi'),
);\n";
?>

$this->menu = array(
		array('label'=>Yii::t('app', 'Prikaži') . ' ' . $model->label(4), 'url'=>array('index')),
		array('label'=>Yii::t('app', 'Dodaj') . ' ' . $model->label(5), 'url'=>array('create')),
	);

Yii::app()->clientScript->registerScript('search', "
$('.search-button').click(function(){
	$('.search-form').toggle();
	var innerText = $(\".search-button\").text();
	if (innerText == \"Prikaži opcije za pretragu\") {
		$(\".search-button\").html(\"Sakrij opcije za pretragu\");
	} else {
		$(\".search-button\").html(\"Prikaži opcije za pretragu\");
	}
	return false;
});
$('.search-form form').submit(function(){
	$.fn.yiiGridView.update('<?php echo $this->class2id($this->modelClass); ?>-grid', {
		data: $(this).serialize()
	});
	return false;
});
");
?>

<h1><?php echo '<?php'; ?> echo Yii::t('app', 'Uredi') . ' ' . GxHtml::encode($model->label(4)); ?></h1>

<?php echo "<?php echo GxHtml::link(Yii::t('app', 'Sakrij opcije za pretragu'), '#', array('class' => 'search-button')); ?>"; ?>

<div class="search-form">
<?php echo "<?php \$this->renderPartial('_search', array(
	'model' => \$model,
)); ?>\n"; ?>
</div><!-- search-form -->

<?php echo '<?php'; ?> $this->widget('zii.widgets.grid.CGridView', array(
	'id' => '<?php echo $this->class2id($this->modelClass); ?>-grid',
	'dataProvider' => $model->search(),
	'emptyText' => Yii::t('app', 'Ništa nije pronađeno u bazi podataka.'),
	'summaryText'=>'{start}-{end} od ukupno {count} ' . <?php echo $this->modelClass?>::label(6),
	/* 'filter' => $model, */
	'columns' => array(
<?php
$count = 0;
foreach ($this->tableSchema->columns as $column) {
	if (++$count == 7)
		echo "\t\t/*\n";
	echo "\t\t" . $this->generateGridViewColumn($this->modelClass, $column).",\n";
}
if ($count >= 7)
	echo "\t\t*/\n";
?>
		array(
			'class' => 'CButtonColumn',
			'viewButtonLabel' => Yii::t('app','Pogledaj'),
			'updateButtonLabel' => Yii::t('app','Uredi'),
			'deleteButtonLabel' => Yii::t('app','Obriši'),
			'deleteConfirmation' => Yii::t('app','Da li želite obrisati ovu stavku?'),
		),
	),
)); ?>