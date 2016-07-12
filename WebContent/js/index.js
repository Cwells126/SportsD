
function loadLines(url){
var data;

new Ajax.Request(url, {
  method:'get',
  contentType:'jsonp',
  crossDomain : true,
  onSuccess: function(transport) {
    var response = transport.responseText || "no response text";
    alert("Success! \n\n" + response);
  },
  onFailure: function() { alert('Something went wrong...'); }
});

}