<div class="form">


<?php $form = $this->beginWidget('GxActiveForm', array(
	'id' => 'gallery-image-form',
	'enableAjaxValidation' => false,
	'htmlOptions' => array('enctype' => 'multipart/form-data'),
));
?>

	<p class="note">
		<?php echo Yii::t('app', 'Fields with'); ?> <span class="required">*</span> <?php echo Yii::t('app', 'are required'); ?>.
	</p>

	<?php echo $form->errorSummary($model); ?>

		<div class="row">
		<?php echo $form->labelEx($model,'id_category'); ?>
		<?php echo $form->dropDownList($model, 'id_category', GxHtml::listDataEx(GalleryCategory::model()->findAllAttributes(null, true)), array('prompt'=>'Choose category...')); ?>
		<?php echo $form->error($model,'id_category'); ?>
		</div><!-- row -->
		<?php if ($this->action->id === 'create'): ?>
			<div class="row">
			<?php echo $form->labelEx($model,'image'); ?>
			<?php echo $form->fileField($model, 'image'); ?>
			<?php echo $form->error($model,'image'); ?>
			</div><!-- row -->
		<?php else: ?>
			<?php echo $form->hiddenField($model, 'image'); ?>
		<?php endif; ?>
		<div class="row">
		<?php echo $form->labelEx($model,'description'); ?>
		<?php echo $form->textField($model, 'description', array('maxlength' => 255)); ?>
		<?php echo $form->error($model,'description'); ?>
		</div><!-- row -->


<?php
echo GxHtml::submitButton(Yii::t('app', 'Save'));
$this->endWidget();
?>
</div><!-- form -->