import riak

riakClient = riak.RiakClient(pb_port=8087)
Bucket = riakClient.bucket("s23785")

person = {"name": "Maciej","surname": "Chrescionko"}

newPerson = Bucket.new(person["name"], data = person)
newPerson.store()
print("dodano osobe")

fetchedperson = Bucket.get(person["name"])
print("pobrano osobe: " + fetchedperson.encoded_data)

fetchedperson.data["surname"] = "Nowak"

print("zaktualizowano osobe")
fetchedperson.store()

fetchedperson = Bucket.get(person["name"])
print("osoba: " + fetchedperson.encoded_data)

fetchedperson.delete()
assert Bucket.get(person["name"]).exists == False
print("osoba usunieta")

fetchedperson = Bucket.get(person["name"])
print("brak")
print(fetchedperson.encoded_data)