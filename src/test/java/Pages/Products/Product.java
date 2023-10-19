package Pages.Products;


    public class Product {
        public double price;
        public String description;
        public String name;
        public String pictureUrl;

        // Constructor
        public Product(double price, String description, String name, String pictureUrl) {
            this.price = price;
            this.description = description;
            this.name = name;
            this.pictureUrl = pictureUrl;
        }

        // Getters and Setters
        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPictureUrl() {
            return pictureUrl;
        }

        public void setPictureUrl(String pictureUrl) {
            this.pictureUrl = pictureUrl;
        }

        // Override toString() method (Optional, for easy debugging)
        @Override
        public String toString() {
          StringBuilder sb = new StringBuilder();
            sb.append("Name: ").append(name);
            sb.append("Description: ").append(description);
            sb.append("Price: ").append(price);
            sb.append("ImageURL: ").append(pictureUrl);

            return sb.toString();
        }
    }


