/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	   config.language = 'es';
	   config.pasteFromWordRemoveFontStyles = false;
	   config.scayt_sLang = 'es_ES';
	   config.scayt_autoStartup = true;
	// config.uiColor = '#AADC6E';
	   config.height = 300;
		config.contentsCss = [ 'https://cdn.ckeditor.com/4.7.3/full-all/contents.css', 'mystyles.css' ];
		// This is optional, but will let us define multiple different styles for multiple editors using the same CSS file.
		config.bodyClass = 'document-editor';
};
