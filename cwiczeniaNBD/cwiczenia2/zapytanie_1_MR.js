var mapping = function(){
	var key = this.sex;
	var value = {
        	count: 1,
	        height: parseFloat(this.height),
		weight: parseFloat(this.weight)
	};        
	emit (key, value);
};
     
var reducing = function (key, values){
	reduceVal = {count: 0, height: 0, weight: 0};
	for (var i = 0; i < values.length; i++) {
	        reduceVal.height += values[i].height;
	        reduceVal.weight += values[i].weight;
	        reduceVal.count += values[i].count;}
	 return reduceVal;
};

var finalizing = function (key, reduceVal){
	reduceVal.weight = reduceVal.weight/reduceVal.count;
	reduceVal.height = reduceVal.height/reduceVal.count;
	    
	return reduceVal;
};

db.people.mapReduce(mapping, reducing, {out: "mp1", finalize: finalizing})
db.mp1.find({})