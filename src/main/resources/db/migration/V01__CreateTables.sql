-- Products table
CREATE TABLE Products(
  ID INT NOT NULL AUTO_INCREMENT,
  Name VARCHAR(100) NOT NULL,
  Description VARCHAR(1000) NOT NULL,
  PRIMARY KEY (ID)
);
-- Reviews table containing reviews linked to products
CREATE TABLE Reviews(
  ID INT NOT NULL AUTO_INCREMENT,
  Title VARCHAR(100) NOT NULL,
  Description VARCHAR(1000),
  Score INT NOT NULL,
  Username VARCHAR(100) NOT NULL,
  Product_ID INT NOT NULL,
  PRIMARY KEY (ID),
  FOREIGN KEY (Product_ID)
    REFERENCES Products(ID)
    ON DELETE CASCADE
);
-- Comments table containing comments linked to reviews
CREATE TABLE Comments(
  ID INT NOT NULL AUTO_INCREMENT,
  Text VARCHAR(1000) NOT NULL,
  Username VARCHAR(100) NOT NULL,
  Review_ID INT NOT NULL,
  PRIMARY KEY (ID),
  FOREIGN KEY (Review_ID)
    REFERENCES Reviews(ID)
    ON DELETE CASCADE
);