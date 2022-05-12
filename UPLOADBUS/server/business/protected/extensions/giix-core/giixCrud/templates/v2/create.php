<?php
/**
 * The following variables are available in this template:
 * - $this: the CrudCode object
 */
?>
<?php
echo "<?php\n\n\$this->pageTitle=Yii::t('app', 'Napravi') . ' ' . \$model->label(5);\n
\$this->breadcrumbs = array(
	\$model->label(2) => array('index'),
	Yii::t('app', 'Napravi'),
);\n";
?>

$this->menu = array(
	array('label'=>Yii::t('app', 'Prikaži') . ' ' . $model->label(4), 'url' => array('index')),
	array('label'=>Yii::t('app', 'Uredi') . ' ' . $model->label(4), 'url' => array('admin')),
);
?>

<h1><?php echo '<?php'; ?> echo Yii::t('app', 'Napravi') . ' ' . GxHtml::encode($model->label(5)); ?></h1>

<?php echo "<?php\n"; ?>
$this->renderPartial('_form', array(
		'model' => $model,
		'buttons' => 'create'));
<?php echo '?>'; ?>