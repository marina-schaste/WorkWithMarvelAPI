(function(){
    console.log("Test!");
})();
function chooseCount(self) {
    window.location.href = "./"+self.dataset.link+"?count="+self.options[self.selectedIndex].value;
}