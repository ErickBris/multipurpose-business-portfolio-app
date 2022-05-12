<?php

Yii::import('application.models._base.BaseOurTeam');

class OurTeam extends BaseOurTeam
{
	public static function model($className=__CLASS__) {
		return parent::model($className);
	}
	
	public static function representingColumn() {
		return array('first_name' , 'last_name');
	}

	public static function label($n = 1) {
		return Yii::t('app', 'Our Team Member|Our Team Members', $n);
	}
}