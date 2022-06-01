//마일리지 숫자로 연산 및 db 계산값 Controller 보내주기
//결제내용 전송 
  		
  		//결제하기버튼
  		function checkPay(){
  			var listVar = $("input[name='selectPay']:checked").val();
			const getMoney = document.getElementById('money');
  			var moneyText = getMoney.innerText;
			var regex = /[^0-9]/g;
  			var finalAmount = moneyText.replace(regex, "");
    	  	console.log(listVar);
			console.log(finalAmount);
    	  	if(listVar == "payco"){
    	  		//함수 안에 가격,결제내용 을 보내줄 예정
    	  		request_pay2("payco",finalAmount);
    	  	}else if(listVar == "kakaopay"){
    	  		request_pay2("kakaopay",finalAmount);
    	  	}else if(listVar == "toss"){
    	  		request_pay2("tosspay",finalAmount);
    	  	};
  		}
		
		//쿠폰사용 버튼
		function useCoupon(){
			
		}

  	  
  		//마일리지 사용하기 버튼
  		function useMilage(){
			//총 금액 가져오기
  			const getMoney = document.getElementById('money');
			var moneyText = getMoney.innerText;
			//총 할인금액 가져오기
			const getTotalDiscount = document.getElementById('totalDiscount');
			var totalDiscount = getTotalDiscount.innerText;
			//쿠폰금액 가져오기
			const getCoupon = document.getElementById('useCoupon');
			var couponAmount = parseInt(getCoupon.innerText);
			//사용 마일리지
			const getUsedMilage = document.getElementById('useMileage');
  			
			//마일리지 입력값 가져오기
  			 var getMile = document.getElementById('milage').value;
//   			 if(보유마일리지>사용마일리지){
//   				 alert("보유마일리지가 부족합니다!")
//   			 }else{실행};

			 //숫자만 빼오기
  			 var regex = /[^0-9]/g;
  			 var changeMoney = moneyText.replace(regex, "");
			 
  			 var totalCalc = changeMoney-getMile;
			 var calcTotalDiscount = couponAmount+parseInt(getMile);
			 
		
  			 alert("마일리지가 사용되었습니다!");
			 getTotalDiscount.innerHTML
				= '<p style="color:tomato;">'+calcTotalDiscount+'</p>';
			 getUsedMilage.innerHTML
				= '<p style="color:tomato;">'+getMile+'</p>';
  			 getMoney.innerHTML 
  			    = '<h4><i class="fa fa-credit-card-alt"></i>&nbsp;&nbsp;Final Amount &nbsp;&nbsp;<small class="text-muted">최종 금액</small></h4><br><h1><i class="fa fa-krw"></i>&nbsp;'+totalCalc+'</h1>';
							
  		}
  		
  
	  var IMP = window.IMP; 
	  IMP.init("imp97334987");
	  
	  
	 //값에 따른 결제창
	 function request_pay2(pgText,finalAmount){
		console.log(pgText);
		 IMP.request_pay({
			    pg : pgText,  // KG이니시스 일반결제창 호출(상점아이디 MID-a 적용)
			    amount : finalAmount,
			    name : "api 페이코 주문 테스트",
			    buyer_name : "송중기",
			    buyer_email : "buyer@iamport.kr"
			  }, function(rsp) {
			    if ( rsp.success ) {
			    	var msg = '결제가 완료되었습니다.';
	    			msg += '\n고유ID : ' + rsp.imp_uid;
	    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
	    			msg += '\n결제 금액 : ' + rsp.paid_amount;
	    			msg += '\n카드 승인번호 : ' + rsp.apply_num;
	    			alert(msg);
			    	//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
			    	jQuery.ajax({
			    		url: "./payment/pay.do", 
			    		type: 'POST',
			    		dataType: 'json',
			    		data: {
				    		imp_uid : rsp.imp_uid,
				    		merchant_uid : rsp.merchant_uid
				    		//기타 필요한 데이터가 있으면 추가 전달
			    		}
			    	}).done(function(data){
			    		//[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
						alert("정상");			    			
			    	});
			    } else {
			        var msg = '결제에 실패하였습니다.';
			        msg += '에러내용 : ' + rsp.error_msg;
			        
			        alert(msg);
			    }
			});
	 }
	 
	//환불
	 function doF(){
		 $.ajax({
			 type:"post",
			 url:"./payment/cancel.do",
			 success:function(result){
				console.log(result);
				location.href="./payment/moveNext";
				 
			 }
		 })
	 }
	 
	//조회
	 function doCheck(){
		 $.ajax({
			 type:"post",
			 url:"./payment/payInfo.do",
			 success:function(result){
				 console.log(result);
				 location.href="./payment/moveNext";
			 }
		 })
	 }