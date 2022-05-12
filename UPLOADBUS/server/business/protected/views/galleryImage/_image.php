<?php if ($model->image == null)
		echo '<p>Picture not uploaded.</p><p>Upload new image:</p>';
	else {
		echo 'Current image:</br>';
		echo CHtml::image('/business/admin/uploads/' . $model->id . $model->image, $model->image, array('style' => 'max-width:600px;'));
		echo '</br></br><p>Upload new image:</p>';
	}
?>
<div class="form">

	<?php $form = $this -> beginWidget('GxActiveForm', array('id' => 'gallery-category-form', 'enableAjaxValidation' => false, 
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