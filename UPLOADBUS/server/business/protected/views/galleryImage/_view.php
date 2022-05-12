<div class="view">

	<?php echo GxHtml::link(GxHtml::encode($data->image), array('view', 'id' => $data->id)); ?>
	<br />
	<?php echo GxHtml::encode($data->getAttributeLabel('id_category')); ?>:
	<?php echo GxHtml::encode(GxHtml::valueEx($data->idCategory)); ?>
	<br />
	<?php echo CHtml::image('/business/admin/uploads/' . $data->id . $data->image, $data->image, array('style'=>"max-width: 685px;")); ?>
	<br />
</div>