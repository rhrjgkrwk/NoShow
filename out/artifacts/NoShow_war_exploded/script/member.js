function idcheck() {
		if (document.frm.id.value == "") {
			alert('아이디를 입력해주세요.');
			document.frm.id.focus();
			return;
		}
		var url = "idCheck.do?id=" + document.frm.id.value;
		window.open(url,"_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
	}

function use() {
	alert("Ooops");
	//opener.frm.id.value="${id}";
	//opener.frm.reid.value="${id}";
	//self.close();
}