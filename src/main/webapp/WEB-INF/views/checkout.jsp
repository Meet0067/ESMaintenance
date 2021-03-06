<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="login.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout</title>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Lato:400,100,300,700,900);
@import url(https://fonts.googleapis.com/css?family=Source+Code+Pro:400,200,300,500,600,700,900);
.container {
  display: -webkit-box;
  display: flex;
  -webkit-box-align: center;
          align-items: center;
  -webkit-box-pack: center;
          justify-content: center;
  height: 100vh;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
          flex-direction: column;
}

* {
  box-sizing: border-box;
}

html {
  background-color: #f2f2f2;
  font-family: "Lato", sans-serif;
}

.price h1 {
  font-weight: 300;
  color: #18C2C0;
  letter-spacing: 2px;
}

.card {
  margin-top: 30px;
  margin-bottom: 30px;
  width: 520px;
  height: 400px;
}
.card .row {
  height: 20%;
  width: 100%;
  border-bottom: 1.2px solid #292C58;
}
.card .row:last-child {
  border: none;
}
.card .paypal {
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}
.card .details {
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
}
.card .paypal, .card .credit {
  background-color: #1E2148;
}
.card .cardholder, .card .number, .card .details {
  background-color: #242852;
}

.paypal .left, .paypal .right, .credit .left, .credit .right {
  position: relative;
  top: 50%;
  -webkit-transform: translateY(-50%);
          transform: translateY(-50%);
}
.paypal .left, .credit .left {
  float: left;
  margin-left: 50px;
}
.paypal .left label, .credit .left label {
  margin-left: 10px;
  font-size: 1rem;
  cursor: pointer;
  font-weight: 700;
  letter-spacing: 0.5px;
  color: #fff;
}
.paypal .left input[type=radio], .credit .left input[type=radio] {
  visibility: hidden;
}
.paypal .left .radio, .credit .left .radio {
  position: absolute;
  top: -2px;
  left: -20px;
  border: 3px solid #414365;
  width: 25px;
  height: 25px;
  border-radius: 50%;
  background-color: #292B52;
  -webkit-transition: all 0.2s cubic-bezier(0.4, 0, 0.2, 1);
  transition: all 0.2s cubic-bezier(0.4, 0, 0.2, 1);
}
.paypal .left .radio::before, .credit .left .radio::before {
  position: absolute;
  content: "";
  border-radius: 50%;
  top: 5px;
  left: 5px;
  width: 9px;
  height: 9px;
  background-color: transparent;
  -webkit-transition: background-color 0.2s cubic-bezier(0.4, 0, 0.2, 1);
  transition: background-color 0.2s cubic-bezier(0.4, 0, 0.2, 1);
}
.paypal .right, .credit .right {
  float: right;
  margin-right: 30px;
}
.paypal .right img, .credit .right img {
  width: 42px;
  height: 30px;
  margin-left: 10px;
}

input[type=radio]:checked ~ .radio {
  border: 3px solid #90E1E3;
  background-color: #18C2C0;
}
input[type=radio]:checked ~ .radio::before {
  background-color: #fff;
}

.cardholder .info, .number .info {
  position: relative;
  top: 50%;
  -webkit-transform: translateY(-50%);
          transform: translateY(-50%);
  margin-left: 40px;
}
.cardholder .info label, .number .info label {
  display: inline-block;
  letter-spacing: 0.5px;
  color: #8F92C3;
  width: 100px;
}
.cardholder .info input, .number .info input {
  display: inline-block;
  max-width: 300px;
  width: 300px;
  background-color: transparent;
  font-family: "Source Code Pro";
  border: none;
  outline: none;
  margin-left: 50px;
  color: white;
}
.cardholder .info input::-webkit-input-placeholder, .number .info input::-webkit-input-placeholder {
  font-family: "Source Code Pro";
  color: #444880;
}
.cardholder .info input::-moz-placeholder, .number .info input::-moz-placeholder {
  font-family: "Source Code Pro";
  color: #444880;
}
.cardholder .info input:-ms-input-placeholder, .number .info input:-ms-input-placeholder {
  font-family: "Source Code Pro";
  color: #444880;
}
.cardholder .info input::-ms-input-placeholder, .number .info input::-ms-input-placeholder {
  font-family: "Source Code Pro";
  color: #444880;
}
.cardholder .info input::placeholder, .number .info input::placeholder {
  font-family: "Source Code Pro";
  color: #444880;
}

#cardnumber::-webkit-input-placeholder {
  letter-spacing: 2px;
}

#cardnumber::-moz-placeholder {
  letter-spacing: 2px;
}

#cardnumber:-ms-input-placeholder {
  letter-spacing: 2px;
}

#cardnumber::-ms-input-placeholder {
  letter-spacing: 2px;
}

#cardnumber, #cardnumber::placeholder {
  letter-spacing: 2px;
}

.details .left, .details .right {
  position: relative;
  top: 50%;
  -webkit-transform: translateY(-50%);
          transform: translateY(-50%);
}
.details .left {
  float: left;
  padding-left: 40px;
  width: 50%;
}
.details .left label {
  letter-spacing: 0.5px;
  color: #8F92C3;
  width: 100px;
  margin-right: 20px;
}
.details .left select {
  font-family: "Source Code Pro";
  cursor: pointer;
  -webkit-appearance: none;
     -moz-appearance: none;
          appearance: none;
  background: transparent;
  border: none;
  outline: none;
  color: #444880;
}
.details .left span {
  font-family: "Source Code Pro";
  color: #444880;
  margin: 0 2px;
}
.details .right {
  float: right;
  width: 50%;
}
.details .right label {
  margin-right: 20px;
  color: #8F92C3;
}
.details .right input {
  text-align: center;
  width: 50px;
  font-family: "Source Code Pro";
  cursor: pointer;
  background: transparent;
  border: none;
  outline: none;
  color: #fff;
}
.details .right input::-webkit-input-placeholder {
  font-family: "Source Code Pro";
  color: #444880;
}
.details .right input::-moz-placeholder {
  font-family: "Source Code Pro";
  color: #444880;
}
.details .right input:-ms-input-placeholder {
  font-family: "Source Code Pro";
  color: #444880;
}
.details .right input::-ms-input-placeholder {
  font-family: "Source Code Pro";
  color: #444880;
}
.details .right input::placeholder {
  font-family: "Source Code Pro";
  color: #444880;
}
.details .right span {
  text-align: center;
  display: inline-block;
  font-family: "Source Code Pro";
  cursor: pointer;
  margin-left: 50px;
  color: #18C2C0;
  width: 24px;
  height: 24px;
  border: 2px solid #18C2C0;
  border-radius: 50%;
}

.button button {
  font-size: 1.2rem;
  font-weight: 400;
  letter-spacing: 1px;
  width: 520px;
  background-color: #18C2C0;
  border: none;
  color: #fff;
  padding: 18px;
  border-radius: 5px;
  outline: none;
  -webkit-transition: background-color 0.2s cubic-bezier(0.4, 0, 0.2, 1);
  transition: background-color 0.2s cubic-bezier(0.4, 0, 0.2, 1);
}
.button button:hover {
  background-color: #15aeac;
}
.button button:active {
  background-color: #139b99;
}
.button button i {
  font-size: 1.2rem;
  margin-right: 5px;
}

</style>
</head>
<body>
<jsp:include page="userSessionCheck.jsp"></jsp:include>
<%
	int amount = (Integer)request.getAttribute("amount");
	int uid = (Integer)request.getAttribute("uid");
	int fid = (Integer)request.getAttribute("fid");
	
	%>
<div class="container">
    <div class="price">
        <h1>Awesome, that's <%=amount %> !</h1>
        
        
    </div>
    <form action="chargeAmount" method = "post"><input hidden=" " name = "amount" value="<%=amount %>" />
    <div class="card__container">
        <div class="card">
           
            <div class="row credit">
                <div class="left">
                    <input id="cd" type="radio" name="payment" />
                    <div class="radio"></div>
                    <label for="cd">Debit/ Credit Card</label>
                </div>
                <div class="right">
                   <img src="https://img.icons8.com/cute-clipart/64/000000/visa.png"/>
                    <img src="https://img.icons8.com/cute-clipart/64/000000/mastercard.png"/>
                 <img src="https://img.icons8.com/nolan/64/amex.png"/>
                <img src="https://img.icons8.com/color/48/000000/maestro.png"/>
                </div>
            </div>
            <div class="row cardholder">
                <div class="info">
                    <label for="cardholdername">Name</label>
                    <input placeholder="e.g. Richard Bovell" id="cardholdername" type="text" name="name" />
                </div>
            </div>
            <div class="row number">
                <div class="info">
                    <label for="cardnumber">Card number</label>
                    <input id="cardnumber" type="text" pattern="[0-9]{16,19,'-'}" maxlength="19" placeholder="8888-8888-8888-8888" name="card_no"/>
                </div>
            </div>
            <div class="row details">
                <div class="left">
                    <label for="expiry-date">Expiry</label>
                    <select id="expiry-date" name="Ex_month">
                        <option>MM</option>
                        <option value="1">01</option>
                        <option value="2">02</option>
                        <option value="3">03</option>
                        <option value="4">04</option>
                        <option value="5">05</option>
                        <option value="6">06</option>
                        <option value="7">07</option>
                        <option value="8">08</option>
                        <option value="9">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select>
                    <span>/</span>
                     <select id="expiry-date" name="Ex_year">
                        <option>YYYY</option>
                        <option value="16">16</option>
                        <option value="2017">2017</option>
                        <option value="2018">2018</option>
                        <option value="2019">2019</option>
                        <option value="2020">2020</option>
                        <option value="2021">2021</option>
                        <option value="2022">2022</option>
                        <option value="2023">2023</option>
                        <option value="2024">2024</option>
                        <option value="2025">2025</option>
                        <option value="2026">2026</option>
                        <option value="2027">2027</option>
                        <option value="2028">2028</option>
                        <option value="2029">2029</option>
                        <option value="2030">2030</option>
                    </select>
                </div>
                <div class="right">
                    <label for="cvv">CVC/CVV</label>
                    <input type="text" maxlength="4" placeholder="123" name ="cvv"/>
                    <span data-balloon-length="medium" data-balloon="The 3 or 4-digit number on the back of your card." data-balloon-pos="up">i</span>
                </div>
            </div>
        </div>
    </div>
    <div class="button">
        <button type="submit"><i class="ion-locked"></i> Confirm and Pay</button>
    </div>
	</form>
</div>
</body>
</html>