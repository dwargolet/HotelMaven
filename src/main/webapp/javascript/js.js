/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    

    $('#hotelId').focus(function(e) {   
        $(this).blur();
    });
    
    $('.numReqd').keyup(function () { 
	    this.value = this.value.replace(/[^0-9\.]/g,'');	    
    });
 
        
    $('#deleteBtn').click(function () {        
        var hotelId = $("input:radio[name=hotelRadio]:checked").val();
        createRecord.hotelId.value = hotelId;
        window.confirm("Are you sure you want to delete this Hotel?");
        $('#createRecord').attr('action',  "HotelController?action=delete");
         
        $('#createRecord').submit();
        return;
    });
    
   
    return window.confirm("Are you sure you want to delete this Hotel?");
    
    
    
    $('#editBtn').click(function () {
        $('#deleteBtn').prop('disabled', true);
              
        
        var hotelId = $("input:radio[name=hotelRadio]:checked").val();
        createRecord.hotelId.value = hotelId;
        $("input:radio[name=hotelRadio]:checked").each(function(){
                    var $row = $(this).parents('tr'); 
                    var hotelState = $row.find("#listedHotelState").val();                   
                    var hotelName = $row.find("#listedHotelName").val();        
                    var hotelAddress = $row.find("#listedHotelAddress").val();
                    var hotelCity = $row.find("#listedHotelCity").val();                    
                    var hotelZip = $row.find("#listedHotelZip").val();
                    var hotelNote = $row.find("#listedHotelNote").val();
                    
                    createRecord.hotelName.value = hotelName;
                    createRecord.hotelAddress.value = hotelAddress;
                    createRecord.hotelCity.value = hotelCity;
                    createRecord.hotelState.value = hotelState;
                    createRecord.hotelZip.value = hotelZip;
                    createRecord.hotelNote.value = hotelNote;
                    
                });
                
        createRecord.hotelId.value = hotelId;      
        $('#createRecord').attr('action',  "HotelController?action=edit");        
       
       createBtn.value="Edit Record";
        
        return false;
    });
    

    $('#createBtn').click(function () {  
        alert($('#hotelName').val());
        $('#editBtn').prop('disabled', false);
        $('#deleteBtn').prop('disabled', false);
        
        $('#createRecord').submit();
        return;
    });

});