<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Connect Card</title>
        <meta name=viewport content="user-scalable=no,width=device-width" />
        <link rel=stylesheet href=http://code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.css />
        <script src=js/common.js></script>
        <script src=http://code.jquery.com/jquery-1.6.min.js></script>
        <script src=http://code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.js></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $.fn.serializeObject = function(){
                    var o = {};
                    var a = this.serializeArray();
                    $.each(a, function() {
                        if (o[this.name] !== undefined) {
                            if (!o[this.name].push) {
                                o[this.name] = [o[this.name]];
                            }
                            o[this.name].push(this.value || '');
                        } else {
                            o[this.name] = this.value || '';
                        }
                    });
                    return o;
                };
            });
            
            
            
            /**
             * This function logs the user in
             * @returns
             */
            function login(){
                $.ajax({
                    type: "POST",
                    url: "login.htm",
                    data: { email: "coreyharden@yahoo.com", location: "Boston" }
                }).done(function(msg) {
                    var obj = $.parseJSON(msg);
                    alert(obj.error);
                });
            }
        </script>
    <body>
        <!-- page -->
        <div data-role="page" id="win1">
            <!-- header -->
            <div data-role="header">
                <h1>Page Title</h1>
            </div>
            <!-- /header -->
            <!-- content -->
            <div data-role="content" data-theme=e>
                <p>This is the Mobile Home Page.</p>
                <a href="#win2" data-transition=pop> Goto window 2 </a>
                <form>
                    <li data-role="fieldcontain" class="ui-field-contain ui-body ui-br ui-li ui-li-static ui-btn-up-c">
                        <fieldset data-role="controlgroup" class="ui-corner-all ui-controlgroup ui-controlgroup-vertical">
                            <div role="heading" class="ui-controlgroup-label">Choose a pet:</div>
                            <div class="ui-controlgroup-controls">		    	
                                <div class="ui-radio"><input type="radio" name="radio-choice-1" id="radio-choice-1" value="choice-1" checked="checked"><label for="radio-choice-1" data-corners="true" data-shadow="false" data-iconshadow="true" data-wrapperels="span" data-icon="radio-off" data-theme="c" data-mini="false" class="ui-btn ui-btn-up-c ui-fullsize ui-btn-icon-left ui-radio-on ui-corner-top"><span class="ui-btn-inner ui-corner-top"><span class="ui-btn-text">Cat</span><span class="ui-icon ui-icon-shadow ui-icon-radio-on">&nbsp;</span></span></label></div>
                                <div class="ui-radio"><input type="radio" name="radio-choice-1" id="radio-choice-2" value="choice-2"><label for="radio-choice-2" data-corners="true" data-shadow="false" data-iconshadow="true" data-wrapperels="span" data-icon="radio-off" data-theme="c" data-mini="false" class="ui-btn ui-btn-up-c ui-fullsize ui-btn-icon-left ui-radio-off"><span class="ui-btn-inner"><span class="ui-btn-text">Dog</span><span class="ui-icon ui-icon-radio-off ui-icon-shadow">&nbsp;</span></span></label></div>
                                <div class="ui-radio"><input type="radio" name="radio-choice-1" id="radio-choice-3" value="choice-3"><label for="radio-choice-3" data-corners="true" data-shadow="false" data-iconshadow="true" data-wrapperels="span" data-icon="radio-off" data-theme="c" data-mini="false" class="ui-btn ui-btn-up-c ui-fullsize ui-btn-icon-left ui-radio-off"><span class="ui-btn-inner"><span class="ui-btn-text">Hamster</span><span class="ui-icon ui-icon-radio-off ui-icon-shadow">&nbsp;</span></span></label></div>
                                <div class="ui-radio"><input type="radio" name="radio-choice-1" id="radio-choice-4" value="choice-4"><label for="radio-choice-4" data-corners="true" data-shadow="false" data-iconshadow="true" data-wrapperels="span" data-icon="radio-off" data-theme="c" data-mini="false" class="ui-btn ui-btn-up-c ui-fullsize ui-btn-icon-left ui-radio-off ui-corner-bottom ui-controlgroup-last"><span class="ui-btn-inner ui-corner-bottom ui-controlgroup-last"><span class="ui-btn-text">Lizard</span><span class="ui-icon ui-icon-radio-off ui-icon-shadow">&nbsp;</span></span></label></div>
                            </div>
                        </fieldset>
                    </li>


                    <li data-role="fieldcontain" class="ui-field-contain ui-body ui-br ui-li ui-li-static ui-btn-up-c"><label for="select-choice-3" class="select ui-select">Your state:</label><div class="ui-select"><div data-corners="true" data-shadow="true" data-iconshadow="true" data-wrapperels="span" data-icon="arrow-d" data-iconpos="right" data-theme="c" class="ui-btn ui-btn-up-c ui-shadow ui-btn-corner-all ui-btn-icon-right"><span class="ui-btn-inner ui-btn-corner-all"><span class="ui-btn-text"><span>Alabama</span></span><span class="ui-icon ui-icon-arrow-d ui-icon-shadow">&nbsp;</span></span><select name="select-choice-3" id="select-choice-3">
                                    <option value="AL">Alabama</option>
                                    <option value="AK">Alaska</option>
                                    <option value="AZ">Arizona</option>
                                    <option value="AR">Arkansas</option>
                                    <option value="CA">California</option>
                                    <option value="CO">Colorado</option>
                                    <option value="CT">Connecticut</option>
                                    <option value="DE">Delaware</option>
                                    <option value="FL">Florida</option>
                                    <option value="GA">Georgia</option>
                                    <option value="HI">Hawaii</option>
                                    <option value="ID">Idaho</option>
                                    <option value="IL">Illinois</option>
                                    <option value="IN">Indiana</option>
                                    <option value="IA">Iowa</option>
                                    <option value="KS">Kansas</option>
                                    <option value="KY">Kentucky</option>
                                    <option value="LA">Louisiana</option>
                                    <option value="ME">Maine</option>
                                    <option value="MD">Maryland</option>
                                    <option value="MA">Massachusetts</option>
                                    <option value="MI">Michigan</option>
                                    <option value="MN">Minnesota</option>
                                    <option value="MS">Mississippi</option>
                                    <option value="MO">Missouri</option>
                                    <option value="MT">Montana</option>
                                    <option value="NE">Nebraska</option>
                                    <option value="NV">Nevada</option>
                                    <option value="NH">New Hampshire</option>
                                    <option value="NJ">New Jersey</option>
                                    <option value="NM">New Mexico</option>
                                    <option value="NY">New York</option>
                                    <option value="NC">North Carolina</option>
                                    <option value="ND">North Dakota</option>
                                    <option value="OH">Ohio</option>
                                    <option value="OK">Oklahoma</option>
                                    <option value="OR">Oregon</option>
                                    <option value="PA">Pennsylvania</option>
                                    <option value="RI">Rhode Island</option>
                                    <option value="SC">South Carolina</option>
                                    <option value="SD">South Dakota</option>
                                    <option value="TN">Tennessee</option>
                                    <option value="TX">Texas</option>
                                    <option value="UT">Utah</option>
                                    <option value="VT">Vermont</option>
                                    <option value="VA">Virginia</option>
                                    <option value="WA">Washington</option>
                                    <option value="WV">West Virginia</option>
                                    <option value="WI">Wisconsin</option>
                                    <option value="WY">Wyoming</option>
                                </select>
                            </div>
                        </div>
                    </li>

                    <li class="ui-body ui-body-b ui-li ui-li-static ui-btn-up-c ui-li-last">
                        <fieldset class="ui-grid-a">
                            <div class="ui-block-a"><div data-corners="true" data-shadow="true" data-iconshadow="true" data-wrapperels="span" data-icon="null" data-iconpos="null" data-theme="d" class="ui-btn ui-btn-up-d ui-shadow ui-btn-corner-all ui-submit" aria-disabled="false"><span class="ui-btn-inner ui-btn-corner-all"><span class="ui-btn-text">Cancel</span></span><button type="submit" data-theme="d" class="ui-btn-hidden" aria-disabled="false">Cancel</button></div></div>
                            <div class="ui-block-b"><div data-corners="true" data-shadow="true" data-iconshadow="true" data-wrapperels="span" data-icon="null" data-iconpos="null" data-theme="a" class="ui-btn ui-btn-up-a ui-shadow ui-btn-corner-all ui-submit" aria-disabled="false"><span class="ui-btn-inner ui-btn-corner-all"><span class="ui-btn-text">Submit</span></span><button type="submit" data-theme="a" class="ui-btn-hidden" aria-disabled="false" onclick="login()">Submit</button></div></div>
                        </fieldset>
                    </li>			
                    </ul>		
                </form>
            </div>
            <!-- /content -->
            <!-- footer -->
            <div data-role="footer">
                <h4>Page Footer</h4>
            </div>
            <!-- /footer -->
        </div>
        <!-- /page -->
        <!-- page -->
        <div data-role="page" id="win2" data-add-back-btn=true>
            <!-- header -->
            <div data-role="header">
                <h1>Page Title</h1>
            </div>
            <!-- /header -->
            <!-- content -->
            <div data-role="content">
                <p>Oh Yeah!</p>
            </div>
            <!-- /content -->
            <!-- footer -->
            <div data-role="footer">
                <h4>Page Footer</h4>
            </div>
            <!-- /footer -->
        </div>
        <!-- /page -->
</html>
