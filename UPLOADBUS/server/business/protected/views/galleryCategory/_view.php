<div class="view">

	<?php echo GxHtml::link(GxHtml::encode($data->name), array('view', 'id' => $data->id)); ?>
	<?php echo CHtml::image('/business/admin/uploads/' . $data->id . $data->image, $data->image, array('style'=>"max-width: 685px;")); ?>
	<br />

</div>