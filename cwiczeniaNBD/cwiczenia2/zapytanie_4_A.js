printjson(db.people.aggregate({
	"$group": {
		_id: "$nationality",
		avg_bmi:{"$avg": {"$multiply":[{"$divide":[{"$toDouble":"$weight"},{"$pow":[{"$toDouble":"$height"},2]}]}]}},
		min_bmi:{"$min": {"$multiply":[{"$divide":[{"$toDouble":"$weight"},{"$pow":[{"$toDouble":"$height"},2]}]}]}},
		max_bmi:{"$max": {"$multiply":[{"$divide":[{"$toDouble":"$weight"},{"$pow":[{"$toDouble":"$height"},2]}]}]}},
		}}).toArray())