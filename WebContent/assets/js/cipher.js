$(document).ready(function() {
	
	var cipherDirection = "Encrypt";
	var cipherType = "Shift";
	
	
	function buildCipherPostURL(){
		return cipherType.toLowerCase()+"/"+cipherDirection.toLowerCase();
	}
	
	function buildCipherExampleURL(){
		return ctx +"/assets/cipherexamples/"+ cipherType.toLowerCase() + "-examples.json";
	}
	
	function getRandomInt(min, max) {
		  min = Math.ceil(min);
		  max = Math.floor(max);
		  return Math.floor(Math.random() * (max - min)) + min;
	}
	
	$('#clear').click(function(e) {
		$('.form-control').val('');
		$('select.form-control').prop('selectedIndex',0);
	});
	
	$('#cipher-example').click(function(e) {
		$.getJSON( buildCipherExampleURL(), function( data ) {
			// Get a random example
			var rndIdx = getRandomInt(0, Object.keys(data).length );
			// Only add the key if we aren't auto decrypting
			if(cipherDirection !== "AutoDecrypt"){
				$('.active-key-panel .key-input').each(function() {
					 $(this).val(data[rndIdx][$(this).attr('name')]);
				});
			}
			
			// Add the text
			if(cipherDirection === "Encrypt"){
				$('#plain-text').val(data[rndIdx].plainText);
			} else {
				$('#cipher-text').val(data[rndIdx].cipherText);
			}
		});
		
	});
	
	$(".cipher-form").submit(function(e) {
	    var $form = $(this);

	    sanitizeTextInputs();
	    	    
	    var jqxhr = $.post(buildCipherPostURL(), $form.serialize(), function(response) {
	    	console.log(response);
	    	$('.errors').empty();
			//Remove hasError from all elements
	    	$('.has-error').removeClass('has-error');
			if(cipherDirection === "Encrypt"){
				$('#cipher-text').val(response.cipherText);
			} else {
				if(cipherDirection === "AutoDecrypt") {
					$('#plain-text').val(response.plainText.plainText);
					var $keyInput = $('.active-key-panel .key-input');
					$keyInput.val(response.key[$keyInput.attr('name')]);
				} else {
					$('#plain-text').val(response.plainText);
				}
			}
	    }).fail(function(errors) {
	    	console.log(errors);
			$('.errors').empty();
	    	//Remove hasError from all elements
	    	$('.has-error').removeClass('has-error');
	    	errors.responseJSON.fieldErrors.forEach(function(error){
	    		$('.cipher-form [name=' + error.field + ']').closest('.form-group').addClass('has-error');
	    		var $li = $("<li>").text(error.message);
	    		$('.errors').append($li);
	    	})
	    });

	    event.preventDefault(); // Important! Prevents submitting the form.

	});	

    $('#cipher-type-buttons > button').click(function(e) {
        e.preventDefault();
		
		// remove 'active' class from all buttons
        $(this).siblings('button.active').removeClass('active');
		// add 'active' class to 'this' button
        $(this).addClass('active');
		
		cipherType = $(this).text();
		// Change the title
		$('#cipherTitle').text(cipherType);
		
		// remove 'active' class from all key panels
		$('.active-key-panel').removeClass('active-key-panel');
		// add 'active' class to corresponding key panel
		$('#'+cipherType.toLowerCase()+'-key-panel').addClass('active-key-panel');
		
		// enable/disable auto-decryption
		if(cipherType === "Vigenere" || cipherType === "Shift"){
			$('#btn-auto-decrypt').show();
		} else {
			$('#btn-auto-decrypt').hide();
			if($('#btn-auto-decrypt').hasClass('active')){
				$('#btn-auto-decrypt').removeClass('active');
				$('#btn-encrypt').click();
			}
		}
		
		disableControls();
    });
    $('#cipher-direction-buttons > button').click(function(e) {
        e.preventDefault();
        $(this).siblings('button.active').removeClass('active');
        $(this).addClass('active');
				
		$('#submit').prop('value',$(this).text());
		cipherDirection = $(this).attr('name');
	
		disableControls();

    });
    
    function sanitizeTextInputs(){
    	
    	var $plainText = $('#plain-text');
    	$plainText.val($plainText.val().toUpperCase());	    
	    $plainText.val($plainText.val().replace(/[^A-Z]/g, ''));
	    
    	var $cipherText = $('#cipher-text');
    	$cipherText.val($cipherText.val().toUpperCase());	    
    	$cipherText.val($cipherText.val().replace(/[^A-Z]/g, ''));
    	
		var $keyInput = $('.active-key-panel textarea');
		if($keyInput.val()){
			$keyInput.val($keyInput.val().toUpperCase());	
			$keyInput.val($keyInput.val().replace(/[^A-Z]/g, ''));
		}
    }
    	
	function disableControls(){

		if(cipherDirection === "Encrypt"){
			var plainTextDisabled = false;
			var cipherTextDisabled = true;
			var inputDisabled = false;
		} else {
			plainTextDisabled = true;
			cipherTextDisabled = false;
			if(cipherDirection === "Decrypt"){
				inputDisabled = false;
			} else {
				inputDisabled = true;
			}
		}
		
		$('#plain-text').prop('disabled', plainTextDisabled);
		$('#cipher-text').prop('disabled', cipherTextDisabled);
		$('.active-key-panel .form-control').prop('disabled', inputDisabled);
	}
	
	disableControls();
});