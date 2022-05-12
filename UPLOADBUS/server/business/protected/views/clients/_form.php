<div class="form">


<?php $form = $this->beginWidget('GxActiveForm', array(
	'id' => 'clients-form',
	'enableAjaxValidation' => false,
	'htmlOptions' => array('enctype' => 'multipart/form-data'),
));
?>

	<p class="note">
		<?php echo Yii::t('app', 'Fields with'); ?> <span class="required">*</span> <?php echo Yii::t('app', 'are required'); ?>.
	</p>

	<?php echo $form->errorSummary($model); ?>

		<div class="row">
		<?php echo $form->labelEx($model,'name'); ?>
		<?php echo $form->textField($model, 'name', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'name'); ?>
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
		<?php echo $form->textArea($model, 'description'); ?>
		<?php echo $form->error($model,'description'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'website'); ?>
		<?php echo $form->textField($model, 'website', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'website'); ?>
		</div><!-- row -->
		<?php if ($this->action->id === 'update'): ?>
			<div class="row">
			<?php echo $form->labelEx($model,'is_active'); ?>
			<?php echo $form->checkBox($model, 'is_active'); ?>
			<?php echo $form->error($model,'is_active'); ?>
			</div><!-- row -->
		<?php else: ?>
			<?php echo $form->hiddenField($model, 'is_active'); ?>
		<?php endif; ?>


<?php
echo GxHtml::submitButton(Yii::t('app', 'Save'));
$this->endWidget();
?>
</div><!-- form -->