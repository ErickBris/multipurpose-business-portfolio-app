<?php
/* @var $this SiteController */
/* @var $error array */

$this->pageTitle=Yii::app()->name . ' - Greška';
$this->breadcrumbs=array(
	'Greška',
);
?>

<h2>Greška <?php echo $code; ?></h2>

<div class="error">
<?php echo CHtml::encode($message); ?>
</div>