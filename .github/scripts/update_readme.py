import os
from datetime import datetime

TOPICS = [
    "Arrays", "Strings", "LinkedList",
    "StackAndQueue", "Trees", "BinarySearch",
    "DynamicProgramming", "Graphs",
    "RecursionAndBacktracking", "Greedy",
    "BitManipulation","ModularArithmetic"
]

DIFFICULTY = {
    # Arrays
    "MergeOverlappingIntervals" : "🟡 Medium",
    "TrappingRainWater"         : "🔴 Hard",
    "InsertInterval"            : "🟡 Medium",
    "RotateMatrix"              : "🟡 Medium",
    # BitManipulation
    "DivideTwoIntegers"         : "🔴 Hard",
    "SingleNumber"              : "🟡 Medium",
    "NumberOf1Bits"             : "🟢 Easy",
    "SingleNumberIII"           : "🟡 Medium",
    #ModularArithmetic
    "ArrayArranger"             : "🟡 Medium",
    "MaximumGcd"                : "🟡 Medium",
    "Pubg"                      : "🟡 Medium"
}

PLATFORM = {
    # Arrays
    "MergeOverlappingIntervals" : "InterviewBit",
    "TrappingRainWater"         : "InterviewBit",
    "InsertInterval"            : "InterviewBit",
    "RotateMatrix"              : "InterviewBit",
    # BitManipulation
    "DivideTwoIntegers"         : "LeetCode",
    "SingleNumber"              : "InterviewBit",
    "NumberOf1Bits"             : "LeetCode",
    "SingleNumberIII"           : "LeetCode",
    "ArrayArranger"             : "LeetCode",
    "MaximumGcd"                : "InterviewBit",
    "Pubg"                      : "InterviewBit",

}

def get_problems():
    problems = {}
    for topic in TOPICS:
        if os.path.exists(topic):
            files = [f.replace(".java", "") for f in os.listdir(topic) if f.endswith(".java")]
            if files:
                problems[topic] = sorted(files)
    return problems

def build_progress_table(problems):
    rows = ""
    for i, topic in enumerate(TOPICS, 1):
        count = len(problems.get(topic, []))
        status = "🟢 Done" if count >= 10 else ("🟡 In Progress" if count > 0 else "🔴 Not Started")
        rows += f"| {i} | {topic} | {count} | {status} |\n"
    return f"""## 📊 Progress Tracker

| # | Topic | Problems Solved | Status |
|---|-------|----------------|--------|
{rows}"""

def build_topic_tables(problems):
    sections = ""
    for topic in TOPICS:
        files = problems.get(topic, [])
        sections += f"\n### 📁 {topic}\n"
        sections += "| # | Problem | Platform | Difficulty | Solution |\n"
        sections += "|---|---------|----------|------------|----------|\n"
        if files:
            for idx, name in enumerate(files, 1):
                platform   = PLATFORM.get(name, "InterviewBit")
                difficulty = DIFFICULTY.get(name, "🟡 Medium")
                path       = f"./{topic}/{name}.java"
                sections  += f"| {idx} | {name} | {platform} | {difficulty} | [View]({path}) |\n"
        else:
            sections += "| - | Coming Soon | - | - | - |\n"
    return f"## 🗂️ Topic Wise Problems\n{sections}"

def build_daily_log(problems):
    log_file = ".github/scripts/daily_log.txt"
    today    = datetime.now().strftime("%Y-%m-%d")

    # Load existing log
    existing_logs = []
    if os.path.exists(log_file):
        with open(log_file, "r") as f:
            existing_logs = f.readlines()

    # Find already logged problem names with their ORIGINAL dates
    logged_names = set()
    for line in existing_logs:
        parts = line.strip().split("|")
        if len(parts) >= 3:
            logged_names.add(parts[1].strip())  # index 1 = problem name

    # Add only NEW problems with today's date
    new_entries = []
    for topic, files in problems.items():
        for name in files:
            if name not in logged_names:
                platform = PLATFORM.get(name, "InterviewBit")
                new_entries.append(f"{today} | {name} | {topic} | {platform}\n")

    # Append new entries BELOW existing ones (preserve old dates)
    all_logs = existing_logs + new_entries

    # Save updated log
    with open(log_file, "w") as f:
        f.writelines(all_logs)

    # Build table rows
    rows = ""
    for line in all_logs:
        parts = line.strip().split("|")
        if len(parts) == 4:
            rows += f"| {parts[0].strip()} | {parts[1].strip()} | {parts[2].strip()} | {parts[3].strip()} |\n"

    return f"""## 📅 Daily Log

| Date | Problem | Topic | Platform |
|------|---------|-------|----------|
{rows}"""

def build_readme(problems):
    total    = sum(len(v) for v in problems.values())
    progress = build_progress_table(problems)
    topics   = build_topic_tables(problems)
    log      = build_daily_log(problems)

    return f"""<h1 align="center">📚 DSA Practice — Daily Consistency</h1>

<p align="center">
  <img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&pause=1000&color=F75C7E&center=true&vCenter=true&width=600&lines=Solving+DSA+Problems+Daily+%F0%9F%9A%80;Topic+by+Topic+%7C+Consistency+is+Key+%F0%9F%94%A5;InterviewBit+%7C+LeetCode+%7C+GFG" alt="Typing SVG" />
</p>

<p align="center">
  <img src="https://img.shields.io/github/commit-activity/w/tejaswini-roopa/DSA?color=brightgreen&label=Weekly%20Commits&style=for-the-badge"/>
  <img src="https://img.shields.io/github/last-commit/tejaswini-roopa/DSA?color=blue&style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java"/>
  <img src="https://img.shields.io/badge/Total%20Problems-{total}-purple?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Status-Active-success?style=for-the-badge"/>
</p>

---

## 👩‍💻 About This Repository

> "My GitHub streak is the only streak I maintain. 💀"

This repository contains my **daily DSA practice** solutions written in **Java**, organized topic by topic.
Every solution includes clean code with proper naming conventions, comments, and test cases.

- 🎯 **Goal:** Solve and push at least one DSA problem every day
- 🗂️ **Structure:** Organized by topics
- 💡 **Platforms:** InterviewBit, LeetCode, GeeksForGeeks
- ☕ **Language:** Java

---

{progress}

---

{topics}

---

{log}

---

## 🛠️ How to Run

\`\`\`bash
# Clone the repo
git clone https://github.com/tejaswini-roopa/DSA.git

# Navigate to any topic folder
cd Arrays

# Compile and run
javac MergeOverlappingIntervals.java
java MergeOverlappingIntervals
\`\`\`

---

## 🌱 My Approach to Each Problem

Every solution file follows this structure:
\`\`\`
1. Problem Understanding  (comment)
2. Approach / Logic       (comment)
3. Clean Code with proper naming conventions
4. Multiple Test Cases in main()
\`\`\`

---



## 📈 GitHub Stats

<p align="center">
  <img src="https://github-readme-stats.vercel.app/api?username=tejaswini-roopa&show_icons=true&theme=radical&hide_border=true&count_private=true" alt="GitHub Stats"/>
  &nbsp;
  <img src="https://github-readme-streak-stats.herokuapp.com/?user=tejaswini-roopa&theme=radical&hide_border=true" alt="GitHub Streak"/>
</p>

---

## 🤝 Connect with Me

<p align="center">
  <a href="https://www.linkedin.com/in/tejaswini-boda">
    <img src="https://img.shields.io/badge/LinkedIn-Connect-blue?style=for-the-badge&logo=linkedin"/>
  </a>
  <a href="https://github.com/tejaswini-roopa">
    <img src="https://img.shields.io/badge/GitHub-Follow-black?style=for-the-badge&logo=github"/>
  </a>
</p>

---

<p align="center">⭐ Star this repo if you find it helpful! Keep grinding 💪</p>
"""

if __name__ == "__main__":
    problems = get_problems()
    readme   = build_readme(problems)
    with open("README.md", "w") as f:
        f.write(readme)
    print("✅ README.md updated successfully!")