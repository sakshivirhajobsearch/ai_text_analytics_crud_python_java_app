# analytics-python/app.py

from flask import Flask, request, jsonify
from analytics import analyze_text

app = Flask(__name__)

@app.route("/analyze", methods=["POST"])
def analyze():
    data = request.get_json()
    text = data.get("text", "")
    result = analyze_text(text)
    return jsonify(result)

if __name__ == "__main__":
    # Run on all interfaces (important if calling from another VM/container)
    app.run(host="0.0.0.0", port=5000, debug=True)
