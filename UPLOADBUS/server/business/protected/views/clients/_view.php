<div class="view">

	<?php echo GxHtml::link(GxHtml::encode($data->name), array('view', 'id' => $data->id)); ?>
	<br />

	<?php echo GxHtml::encode($data->getAttributeLabel('description')); ?>:
	<?php echo GxHtml::encode($data->description); ?>
	<br />
	<?php echo GxHtml::encode($data->getAttributeLabel('website')); ?>:
	<?php echo GxHtml::encode($data->website); ?>
	<br />

</div>