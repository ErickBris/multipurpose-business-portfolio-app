<?php
/**
 * The following variables are available in this template:
 * - $this: the CrudCode object
 */
?>
<?php
echo "<?php\n\n\$this->pageTitle=Yii::t('app', 'Uredi') . ' ' . \$model->label(5) . ': ' . GxHtml::valueEx(\$model);\n
\$this->breadcrumbs = array(
	\$model->label(2) => array('index'),
	GxHtml::valueEx(\$model) => array('view', 'id' => GxActiveRecord::extractPkValue(\$model, true)),
	Yii::t('app', 'Uredi'),
);\n";
?>

$this->menu = array(
	array('label' => Yii::t('app', 'Pregledaj') . ' ' . $model->label(4), 'url'=>array('index')),
	array('label' => Yii::t('app', 'Dodaj') . ' ' . $model->label(5), 'url'=>array('create')),
	array('label' => Yii::t('app', 'Pregledaj ovu') . ' ' . $model->label(5), 'url'=>array('view', 'id' => GxActiveRecord::extractPkValue($model, true))),
	array('label' => Yii::t('app', 'Uredi') . ' ' . $model->label(4), 'url'=>array('admin')),
);
?>

<h1><?php echo '<?php'; ?> echo Yii::t('app', 'Uredi') . ' ' . GxHtml::encode($model->label(5)) . ': ' . GxHtml::encode(GxHtml::valueEx($model)); ?></h1>

<?php echo "<?php\n"; ?>
$this->renderPartial('_form', array(
		'model' => $model));
?>