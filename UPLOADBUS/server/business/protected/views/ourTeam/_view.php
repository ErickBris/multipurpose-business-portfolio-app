<div class="view">

	<?php echo GxHtml::link(GxHtml::encode('Our Team Member'), array('view', 'id' => $data->id)); ?>
	<br />

	<?php echo GxHtml::encode($data->getAttributeLabel('first_name')); ?>:
	<?php echo GxHtml::encode($data->first_name); ?>
	<br />
	<?php echo GxHtml::encode($data->getAttributeLabel('last_name')); ?>:
	<?php echo GxHtml::encode($data->last_name); ?>
	<br />
	<?php echo GxHtml::encode($data->getAttributeLabel('position')); ?>:
	<?php echo GxHtml::encode($data->position); ?>
	<br />
	<?php echo GxHtml::encode($data->getAttributeLabel('phone_number')); ?>:
	<?php echo GxHtml::encode($data->phone_number); ?>
	<br />
	<?php echo GxHtml::encode($data->getAttributeLabel('mobile_number')); ?>:
	<?php echo GxHtml::encode($data->mobile_number); ?>
	<br />
	<?php echo GxHtml::encode($data->getAttributeLabel('fax_number')); ?>:
	<?php echo GxHtml::encode($data->fax_number); ?>
	<br />
	<?php echo GxHtml::encode($data->getAttributeLabel('email')); ?>:
	<?php echo GxHtml::encode($data->email); ?>
	<br />
	<?php echo GxHtml::encode($data->getAttributeLabel('website')); ?>:
	<?php echo GxHtml::encode($data->website); ?>
	<br />
	<?php echo GxHtml::encode($data->getAttributeLabel('address')); ?>:
	<?php echo GxHtml::encode($data->address); ?>
	<br />
	<?php echo GxHtml::encode($data->getAttributeLabel('facebook')); ?>:
	<?php echo GxHtml::encode($data->facebook); ?>
	<br />
	<?php echo GxHtml::encode($data->getAttributeLabel('twitter')); ?>:
	<?php echo GxHtml::encode($data->twitter); ?>
	<br />

</div>