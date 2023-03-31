# Load necessary packages
library(ggplot2)
library(dplyr)
library(lubridate)
# Read in data
#games <- read.csv("C:\Users\Dell\OneDrive\Desktop\all_games.csv")

# Convert release date to a date format and extract year
all_games$release_date <- mdy(all_games$release_date)
all_games$year <- year(all_games$release_date)

all_games <- filter(all_games, year>= 2015 & year <=2020)


# Aggregate data by year and platform
games_agg <- all_games %>% 
  group_by(year, platform) %>% 
  summarise(total_meta_score = sum(meta_score))

# Create plot
plot <- ggplot(games_agg, aes(x=year, y=total_meta_score, fill=platform)) +
  geom_bar(stat="identity", position="dodge") +
  labs(x="Release Year", y="Total Meta Score", title="Game Scores by Year and Platform")

# Save plot
ggsave("game_scores.png", plot, width=8, height=5, dpi=300)
