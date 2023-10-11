/**
 * 
 */

// 회원가입 폼 value 확인하는 자바스크립트
function sendit(){
	let frm = document.joinForm;
	let userid = frm.userid;
	let userpw = frm.userpw;
	let userpw_re = frm.userpw_re;
	let username = frm.username;
	let userphone = frm.userphone;
	
	// 아이디 "" 체크, alert(), focus()
	if(userid.value == ""){
		alert("아이디를 입력하세요");
		userid.focus();
		return false;
	}	
	
	// 아이디 5자 이상, 16자 미만
	if(userid.value.length <= 4 || userid.value.length >= 16){
		alert("아이디는 5자이상, 16자 미만으로 입력하세요.");
		userid.focus();
		return false;
	}
	
	// 비밀번호 "" 체크, alert(), focus()
	if(userpw.value == ""){
		alert("패스워드를 입력하세요");
		userpw.focus();
		return false;
	}
	
	// 비밀번호 8자 이상
	if(userpw.value.length < 8){
		alert("패스워드는 8자리 이상으로 입력하세요!");
		userpw.focus();
		return false;
	}
	
	// 비밀번호 == 비밀번호 확인
	if(userpw.value != userpw_re.value){
		alert("패스워드를 확인하세요");
		userpw_re.focus();
		return false;
	}
	
	// 이름 "" 체크, alert(), focus()
	if(username.value == ""){
		alert("이름을 입력하세요!");
		username.focus();
		return false;
	}
	
	// 휴대폰 번호 "" 체크, alert(), focus()
		if(userphone.value == ""){
		alert("이름을 입력하세요!");
		userphone.focus();
		return false;
	}
	
	// submit()		
	frm.submit();
 }
 
 // 로그인시 validation check
 function logincheck(){
	 // 아이디 "", alert
	 // 비밀번호 "", alert
	 let frm = document.frm;
	 let userid = frm.userid;
	 let userpw = frm.userpw;
	 
	 if( userid.value == "" ){
		 alert("아이디를 입력해주세요");
		 userid.focus();
		 return false;
	 }
	  if( userpw.value == "" ){
		 alert("패스워드를 입력해주세요");
		 userpw.focus();
		 return false;
	 }
	 frm.submit();
	 
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 