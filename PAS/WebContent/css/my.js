/**
 *combobox kelompok barang 
 */
	

/*

	function addComboKelBarang(o,selectedKelBarang,selectedKodeBarang,cmdDest) {
			o.combobox({
				url : 'comboKelBarang.htm?' +"selected="+selectedKelBarang,
				valueField : 'id',
				textField : 'text',
				panelHeight:'auto',
				onSelect: function(rec) {	
					cmdDest.combobox('clear');
					urlk= 'comboKodeBarang.htm?kelBarang=' + xx$('#KodeKelompok')xxo.combobox('getValue')+"&selected="+selectedKodeBarang;
				    cmdDest.combobox('reload', urlk);
					}			
			});
			branchcode = '';
		}
*/
	
	
/*
 * Combobox namaBarang dengan value kosong
 */
/*
	function addComboKodeBarang(o,kelBarang,selected) {
			o.combobox({
				url : 'comboKodeBarang.htm?kelBarang=' + kelBarang+"&selected="+selected,
				valueField : 'id',
				textField : 'text',
				panelHeight:'auto'
			});
			branchcode = '';
		}
	
*/
/*
//lokasi cara pakai addComboLokasi($('#lokasi'),row.lokasi);
	function addComboLokasi(o,selected) {
		o.combobox({
			url : 'combolokasi.htm?'+"selected="+selected,
			valueField : 'id',
			textField : 'text',
			panelHeight:'auto'
		});
		branchcode = '';
	}

*/




	
	/*Combo Yes/No*/
	function comboYesNo(t){
		t.combobox({
			valueField : 'id',
			textField : 'text',
			panelHeight:'auto',
			data:     [{"id":1, "text":"Ya"  },{ "id":0, "text":"Tidak" }]
		});
	}
	
	function comboBulan(t){
		t.combobox({
			valueField : 'id',
			textField : 'text',
			panelHeight:'auto',
			data:     [{"id":'01', "text":"Januari"},
			           {"id":'02', "text":"Februari"},
			           {"id":'03', "text":"Maret"},
			           {"id":'04', "text":"April"},
			           {"id":'05', "text":"Mei"},
			           {"id":'06', "text":"Juni"},
			           {"id":'07', "text":"Juli"},
			           {"id":'08', "text":"Agustus"},
			           {"id":'09', "text":"September"},
			           {"id":'10', "text":"Oktober"},
			           {"id":'11', "text":"November"},
			           {"id":'12', "text":"Desember"}
			           ]
		});
	}
	//comboprovinsi
	function comboProvinsi(t) {
		t.combobox({
			url : 'comboProvinsi.htm?param=' + status+'&param2=',
			valueField : 'id',
			textField : 'text'
		});
		status = '';
	}	

	
	//combo lookup, param2--> value dari lookup
	function comboLookup(t,param2) {
		t.combobox({
			url : 'comboLookup.htm?param=' + ""+'&param2='+param2,
			valueField : 'id',
			textField : 'text',
			panelHeight:'auto'
		});		
	}
//GROUP	
	function comboGroup(t) {
		t.combobox({
			url : 'comboGroup.htm?param=' + groupId,
			valueField : 'id',
			textField : 'text'/*,
			panelHeight:'auto'*/
		});
		groupId = '';
	}
	
//MENU  comboMenu	
	function comboMenu(t) {
		t.combobox({
			url : 'comboMenu.htm?param=' + menuId,
			valueField : 'id',
			textField : 'text'
		});
		menuId = '';
	}	
	
	
	/*tingkat AUDITAN
	 * 
	 */
	/*Kantor auditor*/
	function comboEaTkAuditon(cmbTkAuditan,tkAuditanSelected) {
		cmbTkAuditan.combobox({
			url :'comboEaTkAuditon.htm?param='+tkAuditanSelected+'&param2='+tkAuditanSelected,
			valueField : 'id',
			textField : 'text',
			panelHeight:'auto',
			onSelect: function(rec) {
			}
		});
	}
	
	
	/*Kantor auditor*/
	function comboEaKantorAuditor(cmbKantorAuditor,kantorAuditorSelected) {
		cmbKantorAuditor.combobox({
			url :'comboPasEaKantorAuditorByTk.htm?param='+'&param2='+kantorAuditorSelected,
			valueField : 'id',
			textField : 'text',
			panelHeight:'auto',
			onSelect: function(rec) {
			}
		});
	}
/* combo tK kantor auditor, bila dipilih akan tampil  kantor audito yang tingkanya dipilih*/
	function comboEaTkKantorAuditor(cmbTk,tkSelected,cmbKantorAuditor,kantorAuditorSelected) {
		cmbTk.combobox({
			url :'comboEaTkKantorAuditor.htm?param2='+tkSelected+'&param=',
			valueField : 'id',
			textField : 'text',
			panelHeight:'auto',
			onSelect: function(rec) {
				//alert(cmbTk.combobox('getValue'));
				cmbKantorAuditor.combobox('clear');
				urlz ='comboPasEaKantorAuditorByTk.htm?param='+cmbTk.combobox('getValue')+'&param2='+kantorAuditorSelected;
				cmbKantorAuditor.combobox('reload',urlz);
			}
		});
	}
	
	
	/*Kantor jenis pemeriksaan*/
	function comboEaJenisPemeriksaan(cmb,jenisSelected) {
		cmb.combobox({
			url :'comboEaJenisPemeriksaan.htm?param='+/*'&param2='*/jenisSelected,
			valueField : 'id',
			textField : 'text',
			panelHeight:'auto',
			onSelect: function(rec) {
			}
		});
	}	
	
/* REGION */
	/*=========KABU{ATEN */
	function comboKabupaten(cmbKab,kabupaten) {
		cmbKab.combobox({
			url : '',//'comboAllBranch.htm?param=' + kabupaten
			valueField : 'id',
			textField : 'text',
			panelHeight:'auto'
		});
		kabupaten = '';
	}

	
/*PROVINSI*/
	function comboProvinsiToKabupaten(cmbProvinsi,provinsi,cmbKabupaten,kabupaten) {
		cmbProvinsi.combobox({
			url : 'comboProvinsi.htm?param=' + provinsi+'&param2='+provinsi,
			valueField : 'id',
			textField : 'text',
			onSelect: function(rec) {
				var z = cmbProvinsi.combobox('getValue');
				//alert("kabupaten "+kabupaten);
				cmbKabupaten.combobox('clear');		
		        Urlk = 'comboKabupatenByProvinsi.htm?param='+z+'&param2='+kabupaten;//+          //"&selected="+unit;//11875
		        cmbKabupaten.combobox('reload', Urlk);
		         //alert("rec "+Urlk);
				}
		});
		//status = '';
	}	
	
/* Combo PPL*/
	//GROUP	comboEaPPL
	function comboEaPPL(t) {
		t.combobox({
			url : 'comboEaPPL.htm?param=' +"" ,
			valueField : 'id',
			textField : 'text'/*,
			panelHeight:'auto'*/
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	/* Combo tingkat kantor*/
	function comboEaTkKantorAuditor1(k,kodeTk) {
		k.combobox({
			url : 'comboEaTkKantorAuditor.htm?param=' + kodeTk+'&param2=',
			valueField : 'id',
			textField : 'text',
			panelHeight:'auto'
		});
		kodeTk = '';
	}	
	
//	comboGroup
	//satatus pegawai
/*		function comboGroup(t) {
			t.combobox({
				url : 'comboGroup.htm?param=' + groupId,
				valueField : 'id',
				textField : 'text',
				panelHeight:'auto'
			});
			groupId = '';
		}

*/
//UPPERCASE
function upperCase(t) {
	t.textbox('textbox').bind('keyup', function(e) {
		$(this).val($(this).val().toUpperCase());
	});
}


//tanggal
function getDateTime() {
    var now     = new Date(); 
    var year    = now.getFullYear();
    var month   = now.getMonth()+1; 
    var day     = now.getDate();
    var hour    = now.getHours();
    var minute  = now.getMinutes();
    var second  = now.getSeconds(); 
    if(month.toString().length == 1) {
        var month = '0'+month;
    }
    if(day.toString().length == 1) {
        var day = '0'+day;
    }   
    if(hour.toString().length == 1) {
        var hour = '0'+hour;
    }
    if(minute.toString().length == 1) {
        var minute = '0'+minute;
    }
    if(second.toString().length == 1) {
        var second = '0'+second;
    }   
    var dateTime = year+'/'+month+'/'+day+' '+hour+':'+minute+':'+second;   
     return dateTime;
}

//print
function cetak(){
	printDiv('printArea');
}

function printDiv(divID) {
    //Get the HTML of div
    var divElements = document.getElementById(divID).innerHTML;
    //Get the HTML of whole page
    var oldPage = document.body.innerHTML;

    //Reset the page's HTML with div's HTML only
    document.body.innerHTML = 
      "<html><head><title></title></head><body>" + 
      divElements + "</body>";

    //Print Page
    window.print();

    //Restore orignal HTML
    document.body.innerHTML = oldPage; 
}




