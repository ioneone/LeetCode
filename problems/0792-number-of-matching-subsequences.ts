function numMatchingSubseq(s: string, words: string[]): number {
  const progress = [...Array(words.length)].fill(0);

  // 'a'.charCodeAt(0) - 97 = 0
  // ...
  // 'z'.charCodeAt(0) - 97 = 25
  const buckets = [...Array(26)].map((_) => []);
  for (let i = 0; i < words.length; i++) {
    buckets[words[i].charCodeAt(0) - 97].push(i);
  }

  for (let i = 0; i < s.length; i++) {
    const matches = buckets[s.charCodeAt(i) - 97];
    buckets[s.charCodeAt(i) - 97] = [];
    for (let j = 0; j < matches.length; j++) {
      progress[matches[j]] += 1;
      if (progress[matches[j]] < words[matches[j]].length) {
        buckets[words[matches[j]].charCodeAt(progress[matches[j]]) - 97].push(
          matches[j]
        );
      }
    }
  }

  let ret = 0;
  for (let i = 0; i < words.length; i++) {
    if (progress[i] === words[i].length) {
      ret += 1;
    }
  }
  return ret;
}
