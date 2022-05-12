<?php echo CHtml::form(); ?>
    <div id="langdrop">
        <?php echo CHtml::dropDownList('_lang', $currentLang, array('sr' => 'Srpski',
            'en' => 'English',), array('submit' => '')); ?>
    </div>
<?php echo CHtml::endForm(); ?>