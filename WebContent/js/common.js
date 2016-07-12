/**
 * This a convenience method for getting an
 * element by it's id
 * @param {type} id
 * @returns the element 
 */
function getEI(id){
    return document.getElementById(id);
}


/**
 * This function is a convenience method for
 * getting the value of an elemet
 * @param {type} id
 * @returns 
 */
function getEIV(id){
    if(getEI(id) !== null){
        return document.getElementById(id).value;
    } else {
        return '';
    }
}


