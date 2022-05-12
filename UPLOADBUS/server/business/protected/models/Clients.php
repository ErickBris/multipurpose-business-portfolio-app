<?php

Yii::import('application.models._base.BaseClients');

class Clients extends BaseClients
{
	public static function model($className=__CLASS__) {
		return parent::model($className);
	}
}