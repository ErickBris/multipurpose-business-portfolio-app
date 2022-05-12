<?php
/**
 * The following variables are available in this template:
 * - $this: the CrudCode object
 */
?>
<?php
echo "<?php\n\n\$this->pageTitle=$this->modelClass::label(2);\n
\$this->breadcrumbs = array(
	{$this->modelClass}::label(2),
);\n";
?>

$this->menu = array(
	array('label'=>Yii::t('app', 'Dodaj') . ' ' . <?php echo $this->modelClass; ?>::label(5), 'url' => array('create')),
	array('label'=>Yii::t('app', 'Uredi') . ' ' . <?php echo $this->modelClass; ?>::label(4), 'url' => array('admin')),
);
?>

<h1><?php echo '<?php'; ?> echo GxHtml::encode(<?php echo $this->modelClass; ?>::label(2)); ?></h1>

<?php echo "<?php"; ?>
 
	$dataProvider->pagination->pageSize = 100;
	$this->widget('zii.widgets.CListView', array(
	'dataProvider'=>$dataProvider,
	'itemView'=>'_view',
	'summaryText'=>'{start}-{end} od ukupno {count} ' . <?php echo $this->modelClass?>::label(6),
	'emptyText' => Yii::t('app', 'Ništa nije pronađeno u bazi podataka.'),
)); <?php '?>'; ?>