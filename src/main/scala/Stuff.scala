object Stuff {

  var db: Database = _

  def setDatabase(db: Database) = {
    this.db = db
  }

  def writeAtoDB(): Unit = {
    db.write("A", "string")
    db.close()
  }

  def writeBtoDB(): Unit = {
    db.write("B", "string")
    db.close()
    db.write("B", "string")
    //db.close()    A BUG!!! expected twice
  }
}

trait Database {
  def write(key: String, value: String): Unit

  def close(): Unit
}
