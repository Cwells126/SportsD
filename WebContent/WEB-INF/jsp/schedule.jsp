<!DOCTYPE html>
<%@ page import="com.connectcard.domain.Matchup"%>
<%@ page import="com.connectcard.domain.Team"%>

<%@ page import="java.util.*"%>
<html>
<head>



<meta charset="UTF-8">
<title>Schedule - Football Website Template</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/global.css" type="text/css">




<link rel="stylesheet" href="css/sportsbook_index.css" type="text/css">
<link rel="stylesheet" href="css/main.css" type="text/css"> 
<link rel="stylesheet" href="css/schedule.css" type="text/css" >
<link rel="stylesheet" href="css/dropdownmenu.css" type="text/css">

<script	src="http://ajax.googleapis.com/ajax/libs/prototype/1.7.2.0/prototype.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>


<script src="js/schedule.js" type="text/javascript"> </script>


<script type="text/javascript">
var $j = jQuery.noConflict();
//$j is now an alias to the jQuery function; creating the new alias is optional.

$j(document).ready(function(){
    $j("spinner").bind("ajaxSend", function() {
        $j(this).show();
    }).bind("ajaxStop", function() {
        $j(this).hide();
    }).bind("ajaxError", function() {
        $j(this).hide();
    });
 
     });


//Register event 'click' and associated call back.
Event.observe(window, 'load', function() {
	Event.observe('weekdd', 'click', respondToClick);
});


//Callback function to handle the event.
function awayAmountChange(event) {
	var idNumber = event.id.replace ( /[^\d.]/g, '' );	
	var homeTeam = $('betAmountHome' + idNumber);	
	
	if(event.value > 0){
	$('betAmountHome' + idNumber).disable();
	}else{
	$('betAmountHome' + idNumber).enable();
	}
}

//Callback function to handle the event.
function homeAmountChange(event) {
	var idNumber = event.id.replace ( /[^\d.]/g, '' );	
	var awayTeam = $('betAmountAway' + idNumber);	
	
	if(event.value > 0){
	$('betAmountAway' + idNumber).disable();
	}else{
		$('betAmountAway' + idNumber).enable();
	}
	var betAmnt = $('betAmountHome' +  event.id.replace ( /[^\d.]/g, '' ))
	
	
	var btn = document.createElement('input');
	btn.type = "button";
	btn.className = "btn btn-default cl pull-right";
	btn.value = 'Add '+ betAmnt.innerHTML + ' to Slip';
	btn.onclick = (function(event) {return function() {addBet(event);}})(event);

	var scoreCell = $('homeScoreCell' +  event.id.replace ( /[^\d.]/g, '' ))	

	scoreCell.update(btn);

}

function addBet(entry) {
	var numrows = $$('#teamsPicked tr').length;
	
	$('teamsPicked').insert('<tr> <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</ td></tr>')
	$('teamsPicked').insert('<tr> <td>Falcons</td><td>+3</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>Aints</ td></tr>');

}

// Callback function to handle the event.
function respondToClick() {
  
  var pars = event.target.selectedIndex;
  var url = 'weekChange.htm';
  $('spinner').show();
  
  
  var ajaxRequest = new Ajax.Request(url, {
	    method:       'get', 
	    parameters: {
	        week: pars
	     },
	    data:   pars,
		  onSuccess: function(data) {
			  
			  var scoreUpdates = data.responseText;
			  var responseJson = JSON.parse(scoreUpdates);
			  var headerArray = ['#','MATCHUP','SPREAD','ML','SCORE'];
				var outputCounter =0;
			  var tables = document.getElementsByClassName('sports-table');
			var tablelength = tables.length;
			  
			  for(var tbIndex=0; tbIndex<tablelength; tbIndex+=1){
			  
				var match = tables[tbIndex];
				  
				  
			  var rowLength = match.rows.length;

			  for(var i=0; i<rowLength; i+=1){
			    var row = match.rows[i];


			    var cellLength = row.cells.length;

	      
					 for(var y=0; y<cellLength; y+=1){
				      		var cell = row.cells[y];
			    			if(headerArray.indexOf(cell.innerHTML) < 0){
			    	  
			   		if(cell.id.indexOf('timeCell') > -1){
			    		  
			    	  }else if(cell.id.indexOf('homeTeamCell') > -1){
			    		  			    		  
			    		  cell.update(responseJson[outputCounter]["homeNm"]);
			    		  cell.update(responseJson[outputCounter].homeTeamInfo["logoUrl"]);
			    		  
			    	  }else if(cell.id.indexOf('awayTeamCell') > -1){
			    		  cell.update(responseJson[outputCounter]["awayNm"])
			    		  cell.update(responseJson[outputCounter].awayTeamInfo["logoUrl"]);
			    	  }else if(cell.id.indexOf('lineCell') > -1){
			    		  cell.update(responseJson[outputCounter]["line"])
			    		  
			    	  }else if(cell.id.indexOf('homeScoreCell') > -1){
			    		  responseJson[outputCounter]["homeScore"] != null? cell.update(responseJson[outputCounter]["homeScore"]) : '';
			    		  
			    	  }else if(cell.id.indexOf('awayScoreCell') > -1){
			    		  responseJson[outputCounter]["awayScore"] != null ? cell.update(responseJson[outputCounter]["awayScore"]): ''
			    		  outputCounter++;
			    	  }  
			      }
			      
			    	}
			  	}
			  }
			  $('spinner').hide();
			  
			  var response = transport.responseText || "no response text";
			    alert("Success! \n\n" + response);
			    var xmlMessage = xmlHttpRequest.responseXML;
			    
			    xmlMessage;
			    //$('#result').html(data);
			    //$("#loading_dialog").loading("loadStop");
			    
			  }
	});
}



</script>


</head>

<body>
<div id="spinner" class="spinner" style="display:none;">
    <img id="img-spinner" src="images/spinner.gif" alt="Loading"/>
</div>

	<div class="background">
		<div class="page">
			<div class="header">
				<a href="index.html" id="logo"><img src="images/logo_big.png"
					alt="logo" width="100%"></a>
				<ul>
					<li><a href="news.html">News</a></li>
					<li><a href="team.html">Team</a></li>
					<li class="selected"><a href="schedule.html">Schedule</a></li>
					<li><a href="videos.html">Videos</a></li>
					<li><a href="about.html">About</a></li>
				</ul>
			</div>
					
			<div class="body schedule">
				<div>
					<span></span>
					<div>
						<div class="section">
							<span>Next Game</span>
							<div>
								<p>
									NEXT GAME <br> 26th July 2023 | 7:00AM EST <br> ZZ
									TIGERS STADIUM
								</p>
							</div>
						</div>
						<form method="get" id="weekForm">	
						
						<select id="weekdd" name="WeekDropDown"	>
							<option value="1">Week 1</option>
							<option value="2">Week 2</option>
							<option value="3">Week 3</option>
							<option value="4">Week 4</option>
							<option value="5">Week 5</option>
							<option value="6">Week 6</option>
							<option value="7">Week 7</option>
							<option value="8">Week 8</option>
							<option value="9">Week 9</option>
							<option value="10">Week 10</option>
							<option value="11">Week 11</option>
							<option value="12">Week 12</option>
							<option value="13">Week 13</option>
							<option value="14">Week 14</option>
							<option value="15">Week 15</option>
							<option value="16">Week 16</option>
						</select>
						
						<ul>
							<li><span>Week 1</span>
								<div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="sports-table">
		<tbody>
	<tr class="table_headers">
				<th width="15%">#</th>
				<th width="40%">MATCHUP</th>
				<th width="15%">SPREAD</th>
				<th width="15%">ML</th>
				<th width="15%">SCORE</th>
	</tr>
</tbody>
</table>
</div>


									<%
																
																ArrayList<Matchup> matchups = null;
																matchups = (ArrayList)request.getAttribute("matchups");		 								
																if (matchups != null) {
											int index = 0;
											for (Matchup matchup : matchups) {
												index++;
												Team awayTeamInfo = matchup.getAwayTeamInfo();
									%>
											<div>
																
<table id="sportsTable<%= index%>"  width="100%" border="0" cellpadding="0" cellspacing="0" class="sports-table">

		<tbody id="sportsBody<%=index%>">
			<tr>
				<td id="timeCell<%=index%>" colspan="5"><strong>11/09/2014 1:00PM</strong></td>
			</tr>
			<tr>
				<td width ="15%">251</td>
				<td id="homeTeamCell<%=index%>" width="40%" class="table_line2"> <%= matchup.getHomeTeamInfo().getLogoUrl() %>  <%= matchup.getHomeNm() %></td>
				<td id="lineCell<%=index%>" width="15%"class="table_line2"><%= matchup.getLine() %></td>
				<td width="15%"class="table_line2"> 
				<label for="betAmountHome<%=index%>">
            Amount to bet:
            </label>
            <input type="number" name="betAmtHome" id="betAmountHome<%=index%>" onblur="homeAmountChange(this)" min="5" max="100" step="5" />
       
        </td>
				<td id="homeScoreCell<%=index%>" width="15%"class="table_line2"><%= matchup.getHomeScore() != null ? matchup.getHomeScore(): ""  %></td>
			</tr>
			<tr>
				<td width="15%">252</td>
				<td id="awayTeamCell<%=index%>" width="40%" class="table_line2"> <%= matchup.getAwayTeamInfo().getLogoUrl() %> <%= matchup.getAwayNm() %></td>
				<td width="15%" class="table_line2"> </td>
				<td width="15%"class="table_line2"> 
				<label for="betAmountAway<%=index%>">
            Amount to bet:
            </label>
            <input type="number" name="betAmtAway" id="betAmountAway<%=index%>" onblur="awayAmountChange(this)"  min="5" max="100" step="5"/>
       
        </td>
        <td id="awayScoreCell<%=index%>" width="15%" class="table_line2"><%= matchup.getAwayScore() != null ? matchup.getAwayScore(): "" %></td>
			</tr>
			<tr class="end">
				<td colspan="5"></td>
			</tr>
			
		</tbody>
	</table>	
	</div>
									<%}	
											}%>
														
									</form>
								</li>
						</ul>
					</div>
				</div>
				<div class="sidebar">
<div id="floater" class="float-on" style="top: 190px;overflow-y:auto; position: top;  border: 1px dotted blue;BORDER-WIDTH: 3PX;">
	<span class="top">&nbsp;</span>
	<h2>Bet Slip</h2>
	<span id="summary-link"><a id="ctl00_C_ConstructorSlip1_lnkSummary" class="slip-summary" onmouseover="javascript: Summary_OnMouse('ctl00_C_ConstructorSlip1_Summary1_tblSummary', true);" onmouseout="javascript: Summary_OnMouse('ctl00_C_ConstructorSlip1_Summary1_tblSummary', false);">Your
		Selections</a><table id="ctl00_C_ConstructorSlip1_Summary1_tblSummary" class="slip-summary-table" border="0" cellpadding="0" cellspacing="0" style="visibility: hidden; display: none;">
	<tbody><tr id="ctl00_C_ConstructorSlip1_Summary1_tbrStraight" class="divider">
		<td>Straight:</td>
		<td>
		2
		Bets</td>
	</tr>
</tbody></table>


	</span>
	
	<div id="betting-options" class="hide">
		<table id="ctl00_C_ConstructorSlip1_tblWagerTypes" class="options-table" cellspacing="0">
	<tbody><tr>
		<td class="btn-straight">
				<input type="submit" name="ctl00$C$ConstructorSlip1$btnStraight" value="Straight" id="ctl00_C_ConstructorSlip1_btnStraight" disabled="disabled" title="Select Straight Wager" class="aspNetDisabled btn-off">
				</td>
		<td class="btn-parlays">
				<input type="submit" name="ctl00$C$ConstructorSlip1$btnParlays" value="Parlay" id="ctl00_C_ConstructorSlip1_btnParlays" disabled="disabled" title="Select Parlay Wager" class="aspNetDisabled btn-off">
				</td>
		<td class="btn-ifbet">
				<input type="submit" name="ctl00$C$ConstructorSlip1$btnIfBet" value="If Bet" id="ctl00_C_ConstructorSlip1_btnIfBet" disabled="disabled" title="Select If Bet" class="aspNetDisabled btn-off">
				</td>
	</tr>
	<tr>
		<td class="btn-reverse">
				<input type="submit" name="ctl00$C$ConstructorSlip1$btnActionReverse" value="Reverse" id="ctl00_C_ConstructorSlip1_btnActionReverse" disabled="disabled" title="Select Action Reverse Wager" class="aspNetDisabled btn-off">
				</td>
		<td class="btn-teaser">
				<input type="submit" name="ctl00$C$ConstructorSlip1$btnTeasers" value="Teaser" id="ctl00_C_ConstructorSlip1_btnTeasers" disabled="disabled" title="Select Teaser" class="aspNetDisabled btn-off">
				</td>
		<td class="btn-help">
				<input type="submit" name="ctl00$C$ConstructorSlip1$bntHelp" value="Help" onclick="javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions(&quot;ctl00$C$ConstructorSlip1$bntHelp&quot;, &quot;&quot;, false, &quot;&quot;, &quot;help.aspx&quot;, false, false))" id="ctl00_C_ConstructorSlip1_bntHelp" title="Visit Help Page" class="btn-help">
				</td>
	</tr>
</tbody></table>

	</div>
	
	<div id="ctl00_C_ConstructorSlip1_divAll" class="slip">
		
		
		<div id="bets" >
			
		<div class="tab-content">
			<div id="tab0" class="tab-pane active">
				
					






	
	
	
	
	
	
	
	
	
	
		

		
		
		
			



		<div id="bet_1" class="tkt-bet clearfix">
			
			
				
				
			


			






			
			
							
			
		    						
				<div class="tkt-selection clearfix" id="bsid_Base-SanDi-St.Lo-ACa-MWa-070315MLH">

					<div class="marketDescriptionDetailHeader">

													<table id="teamsPicked" width="85%">
														<tr>
															<td>Bills</td>
															<td>-1</td>
														</tr>
															<tr>
															<td>&nbsp;</td>
															<td>&nbsp;</td>
														</tr>
														<tr>
															<td>Cheifs</td>

														</tr>

													</table>

					</div>
				
				
					
					








<div class="tkt-market">

	

</div>


					
					
						
						
						<span class="market-details glyphicon glyphicon-question-sign"></span> <a href="http://server.lon.liveperson.net/hc/s-66702201/cmd/kbresource/kb-8834789284481491680/view_question!PAGETYPE?sq=pitching+changh&amp;sp=5&amp;sf=101113&amp;sg=1&amp;st=157513&amp;documentid=16878&amp;action=view&amp;VisitorProfile=sportsbook.com" class="secure" target="_blank">Remove</a>
					
				</div>
				
			
	
			
			





			
			
				
				
					
					







				
			
	
						
		</div>
		
		
	
	
	
		
			










		
		
		
	
	
		



	<div id="tkt-action" class="clearfix">
		
			
			
			<button id="cBtn" type="button" class="btn btn-primary pull-right" tab="straight" loadsuggestion="true" login="false">Place Bet</button>
		
		
		
		 
		
		
		
		
			<a id="cLnk" href="clear.sbk" class="btn btn-default cl pull-right">Remove All</a> 
		

	</div>
	
	<div id="cartprocessing" class="noBetsMsg" style="display:none;">
		Please wait while your betting ticket is being processed.

	</div>
	
	

				
			</div>

			

			

			

			
		</div>
			
			
			
		</div>
		<div id="ctl00_C_ConstructorSlip1_htmlButtons" class="submit">
			<table cellspacing="0">
				<tbody><tr>
					<td colspan="2" class="confirm-button">
					<input type="submit" name="ctl00$C$ConstructorSlip1$btnConfirm" value="Place my bets" id="ctl00_C_ConstructorSlip1_btnConfirm" title="Place my bets" class="btn-confirm" onclick="javascript: return ValidateConfirmation(false, 'ctl00_C_ConstructorSlip1');">
					</td>
				</tr>
				<tr>
					<td class="clear-button">
					<input type="submit" name="ctl00$C$ConstructorSlip1$btnClear" value="Clear" id="ctl00_C_ConstructorSlip1_btnClear" title="Clear Bet Slip" class="btn-clear" onclick="javascript: return ConfirmClear('ctl00_C_ConstructorSlip1');">
					</td>
					<td class="save-button">
					<input type="submit" name="ctl00$C$ConstructorSlip1$btnSave" value="Save" id="ctl00_C_ConstructorSlip1_btnSave" title="Save Selections" class="btn-save" onclick="javascript: DisableButton('ctl00_C_ConstructorSlip1');">
					</td>
				</tr>
			</tbody></table>
			<table cellspacing="0">
				<tbody><tr>
					<td colspan="2" class="confirm-button">
					<input type="submit" name="ctl00$C$ConstructorSlip1$btnConfirmOff" value="Place my bets" id="ctl00_C_ConstructorSlip1_btnConfirmOff" disabled="disabled" class="aspNetDisabled btn-invisible-confirm">
					</td>
				</tr>
				<tr>
					<td class="clear-button">
					<input type="submit" name="ctl00$C$ConstructorSlip1$btnClearOff" value="Clear" id="ctl00_C_ConstructorSlip1_btnClearOff" disabled="disabled" class="aspNetDisabled btn-invisible-clear">
					</td>
					<td class="save-button">
					<input type="submit" name="ctl00$C$ConstructorSlip1$btnSaveOff" value="Save" id="ctl00_C_ConstructorSlip1_btnSaveOff" disabled="disabled" class="aspNetDisabled btn-invisible-save">
					</td>
				</tr>
			</tbody></table>
		</div>
		<!-- Sportsbook ads-->

<!--
<a href="/sportsbook/football-lines.aspx"><img src="https://www.betus.com.pa/images/newsite1024/images/betslip-ads/SB-futures.jpg"></a>
-->

<!--
<a href="/sportsbook/football-lines.aspx"><img src="https://www.betus.com.pa/images/newsite1024/images/betslip-ads/SB-XLIX.jpg"></a>
-->

<!--
<a href="/sportsbook/live-betting-odds.aspx"><img src="https://www.betus.com.pa/images/newsite1024/images/betslip-ads/live-betting-basketball.jpg"></a>
-->

<!--
<a href="/sportsbook/live-betting-odds.aspx"><img src="https://www.betus.com.pa/images/newsite1024/images/betslip-ads/live-betting-football.jpg"></a>
-->

<!--
<a href="/sportsbook/live-betting-odds.aspx"><img src="https://www.betus.com.pa/images/newsite1024/images/betslip-ads/live-betting-baseball.jpg"></a>
-->

<!-- Casino ads -->

`<!--
<a href="http://www.betus.com.pa/contests/"><img src="https://www.betus.com.pa/images/newsite1024/images/betslip-ads/free-football-contests-2.jpg"></a> 
-->

<!--
<a href="http://www.betus.com.pa/contests/hockey/power-play/"><img src="https://www.betus.com.pa/images/newsite1024/images/betslip-ads/power-play.jpg"></a> 
-->

<!--
<a href="http://www.betus.com.pa/contests/"><img src="https://www.betus.com.pa/images/newsite1024/images/betslip-ads/free-basketball-contests.jpg"></a> 
-->

<!-- New Casino Promos -->

<!--
<a href="http://casino.betus.com.pa/promotions/monday-morning-quarterback/"><img src="https://www.betus.com.pa/images/newsite1024/images/betslip-ads/monday-morning-quarterback.jpg"></a>
-->

<!--
<a href="http://casino.betus.com.pa/promotions/trifecta-thursdays/"><img src="https://www.betus.com.pa/images/newsite1024/images/betslip-ads/trifecta-thursdays.jpg"></a>  
-->          

<!--
<a href="http://casino.betus.com.pa/promotions/money-back-mondays/"><img src="https://www.betus.com.pa/images/newsite1024/images/betslip-ads/money-back-mondays2.jpg"></a> 
-->

<!-- March Mayhem -->

<!--
<a href="http://www.betus.com.pa/marchmayhem"><img src="https://www.betus.com.pa/images/newsite1024/images/betslip-ads/March Mayhem/mm-bracket-entries.jpg"></a> 
-->

<!--
<a href="http://www.betus.com.pa/marchmayhem"><img src="https://www.betus.com.pa/images/newsite1024/images/betslip-ads/March Mayhem/mm-million-dollar-prize.jpg"></a> 
-->

<!--
<a href="http://www.betus.com.pa/marchmayhem"><img src="https://www.betus.com.pa/images/newsite1024/images/betslip-ads/March Mayhem/mm-round-of-16.jpg"></a> 
-->

<!--
<a href="http://www.betus.com.pa/marchmayhem"><img src="https://www.betus.com.pa/images/newsite1024/images/betslip-ads/March Mayhem/mm-round-of-8.jpg"></a> 
-->    <!--4728-->
	</div>
	
	<div class="clear">&nbsp;</div>
	<span class="bottom">&nbsp;</span>
</div>				
				
	
					
					
					
	
	
	
	
	
	
	
</div>
				</div>
			</div>
			<div class="footer">
				<div>
					<ul>
						<li><a href="index.html">Home</a>|</li>
						<li><a href="news.html">News</a>|</li>
						<li><a href="team.html">Team</a>|</li>
						<li class="selected"><a href="schedule.html">Schedule</a>|</li>
						<li><a href="videos.html">Videos</a>|</li>
						<li><a href="about.html">About</a></li>
					</ul>
					<p>&#169; ZZ TIGERS 2023. All Rights Reserved</p>
				</div>
				<div class="connect">
					<span>Follow Us</span> <a
						href="http://freewebsitetemplates.com/go/facebook/" id="fb">fb</a>
					<a href="http://freewebsitetemplates.com/go/twitter/" id="twitter">twitter</a>
					<a href="http://freewebsitetemplates.com/go/googleplus/"
						id="googleplus">google+</a> <a
						href="http://www.freewebsitetemplates.com/misc/contact"
						id="contact">contact</a>
				</div>
			</div>
		</div>
	</div>


</body>
</html>




<form name="bet-1" action="/sportsbook/betting/proceed/" method="POST">
        <!-- ticket entry -->

						</li>

						   <li>
							    <span class="contest-type">Kansas City Royals/Houston Astros</span>
							    <span class="game-type">Game</span>
							    <div class="clearer"></div>
						   </li>
						   <li class="selected-item  ">	
							    <span class="bet-item">Total Points</span>
                                <span class="coef">

Over 7 (+105)                            </span>                            


                            

                            
						                </li>
                             <!--start pitcher-->
                                    <li>
D Duffy -L must start<br>                                    D Keuchel -L must start                                    </li>

                        <!--end pitcher-->


						              <li class="to-risk"><label>Risk</label><input type="text" readyonly="readonly" disabled="disabled" class="text button-disabled" maxlength="7" value="" id="toRisk_24857149_+105" name="toRisk_24857149"><input type="hidden" name="sid" value="24857149"></li>
						              <li class="to-win"><label>To Win</label><input type="text" readyonly="readonly" disabled="disabled" class="text button-disabled" maxlength="7" value="" id="toWin_24857149_+105" name="toWin_24857149"></li>
					              </ul>
                        <div class="clearer"></div>
				              </div>
                      <!-- end ticket entry -->
  
                        
				        <div class="clearer"></div>
    
                <div class="clearer"></div>
                <div class="clearer"></div>
                
                <p class="warning text-center">
	<span class="icon warning"></span>Please sign in to continue.
</p>
<!-- 15.11.2012: Force text-transform to normal via style (it's a custom style) -->
<p class="notification" style="text-transform: none;">
    Test with <strong><span style="color: #fff;">username: guest</span></strong> <br>and <strong><span style="color: #fff;">password: guest</span></strong>

</p>



<!--Register-->		
<a href="/my-account/sign-in?act=1&amp;returnurl=" target="_parent" class="button button-confirm right">Sign in</a>
<a href="/my-account/register" target="_parent" class="button button-cancel right">New user?</a>
<a href="/sportsbook/betting/del?sq=-1" class="button button-cancel left">clear all</a>
				
<div class="clearer"></div>    
				<div class="clearer"></div>		
                <input type="hidden" name="bst" id="bst" value="S">

			</form>