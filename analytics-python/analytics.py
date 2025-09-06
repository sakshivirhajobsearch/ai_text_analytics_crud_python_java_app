from textblob import TextBlob

def analyze_text(text):
    blob = TextBlob(text)
    return {
        "word_count": len(blob.words),
        "sentiment": blob.sentiment.polarity
    }
