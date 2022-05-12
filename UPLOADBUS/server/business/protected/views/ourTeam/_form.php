<div class="form">


<?php $form = $this->beginWidget('GxActiveForm', array(
	'id' => 'our-team-form',
	'enableAjaxValidation' => false,
	'htmlOptions' => array('enctype' => 'multipart/form-data'),
));
?>

	<p class="note">
		<?php echo Yii::t('app', 'Fields with'); ?> <span class="required">*</span> <?php echo Yii::t('app', 'are required'); ?>.
	</p>

	<?php echo $form->errorSummary($model); ?>

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
		<?php echo $form->labelEx($model,'first_name'); ?>
		<?php echo $form->textField($model, 'first_name', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'first_name'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'last_name'); ?>
		<?php echo $form->textField($model, 'last_name', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'last_name'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'position'); ?>
		<?php echo $form->textField($model, 'position', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'position'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'phone_number'); ?>
		<?php echo $form->textField($model, 'phone_number', array('maxlength' => 20)); ?>
		<?php echo $form->error($model,'phone_number'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'mobile_number'); ?>
		<?php echo $form->textField($model, 'mobile_number', array('maxlength' => 20)); ?>
		<?php echo $form->error($model,'mobile_number'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'fax_number'); ?>
		<?php echo $form->textField($model, 'fax_number', array('maxlength' => 20)); ?>
		<?php echo $form->error($model,'fax_number'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'email'); ?>
		<?php echo $form->textField($model, 'email', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'email'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'website'); ?>
		<?php echo $form->textField($model, 'website', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'website'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'address'); ?>
		<?php echo $form->textField($model, 'address', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'address'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'facebook'); ?>
		<?php echo $form->textField($model, 'facebook', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'facebook'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'twitter'); ?>
		<?php echo $form->textField($model, 'twitter', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'twitter'); ?>
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