<?php if ($model->image == null)
		echo '<p>Image is not added.</p><p>Add new image:</p>';
	else {
		echo 'Current image:</br>';
		echo CHtml::image('/business/admin/uploads/' . $model->id . $model->image, $model->image);
		echo '</br></br><p>Add other image:</p>';
	}
?>
<div class="form">

	<?php $form = $this -> beginWidget('GxActiveForm', array('id' => 'brand-form', 'enableAjaxValidation' => false, 
	 'htmlOptions' => array(
				'enctype' => 'multipart/form-data',
			),
		)
	); ?>
	<div class="row">
		<?php echo $form -> fileField($model, 'image'); ?>
		<?php echo $form -> error($model, 'image'); ?>
	</div><!-- row -->
	
	<?php echo GxHtml::submitButton('Save');
		$this -> endWidget();
	?>
</div><!-- form -->