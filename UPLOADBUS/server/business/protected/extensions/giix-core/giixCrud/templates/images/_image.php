<?php echo '<?php '; ?>if ($model->image == null)
		echo '<p>Slika nije unesena.</p><p>Unesite novu sliku:</p>';
	else {
		echo 'Trenutna slika:</br>';
		echo CHtml::image('/uploads/' . $model->id . $model->image, $model->image);
		echo '</br></br><p>Unesite drugu sliku:</p>';
	}
<?php echo '?>'; ?>

<div class="form">

	<?php echo '<?php'; ?> $form = $this -> beginWidget('GxActiveForm', array('id' => '<?php echo $this->class2id($this->modelClass); ?>-form', 'enableAjaxValidation' => false, 
	 'htmlOptions' => array(
				'enctype' => 'multipart/form-data',
			),
		)
	); <?php echo '?>'; ?>

	<div class="row">
		<?php echo '<?php'; ?> echo $form -> fileField($model, 'image'); <?php echo '?>'; ?>

		<?php echo '<?php'; ?> echo $form -> error($model, 'image'); <?php echo '?>'; ?>

	</div><!-- row -->
	
	<?php echo '<?php'; ?> echo GxHtml::submitButton('Sačuvaj');
		$this -> endWidget();
	<?php echo '?>'; ?>

</div><!-- form -->